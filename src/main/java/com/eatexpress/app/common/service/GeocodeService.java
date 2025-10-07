package com.eatexpress.app.common.service;

import com.eatexpress.app.common.domain.Address;
import com.eatexpress.app.common.domain.GeocodePlace;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${GEOCODE_API_KEY}")
    private String API_KEY;

    @Value("${GEOCODE_BASE_URL}")
    private String BASE_URL;

    public GeocodePlace[] getCoordinatesByAddress(Address address)
        throws MalformedURLException {
        UriComponentsBuilder.newInstance();
        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(
            BASE_URL
        )
            .queryParam("api_key", API_KEY)
            .queryParam(
                "street",
                URLEncoder.encode(
                        address.getHouseNumber(),
                        StandardCharsets.UTF_8
                    ) +
                    "+" +
                    URLEncoder.encode(
                        address.getStreet(),
                        StandardCharsets.UTF_8
                    )
            )
            .queryParam(
                "city",
                URLEncoder.encode(address.getCity(), StandardCharsets.UTF_8)
            )
            .queryParam(
                "postalcode",
                URLEncoder.encode(
                    address.getPostalCode(),
                    StandardCharsets.UTF_8
                )
            )
            .queryParam(
                "country",
                URLEncoder.encode(address.getCountry(), StandardCharsets.UTF_8)
            );

        if (address.getState() != null) urlBuilder.queryParam(
            "state",
            URLEncoder.encode(address.getState(), StandardCharsets.UTF_8)
        );

        URL url = urlBuilder
            .build(false)
            .encode(StandardCharsets.UTF_8)
            .toUri()
            .toURL();
        try {
            ResponseEntity<GeocodePlace[]> response = restTemplate.getForEntity(
                url.toString(),
                GeocodePlace[].class
            );
            System.out.println(response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Handle client and server errors
            // return "Error: " + e.getStatusCode();
            // TODO throw exc
            e.printStackTrace();
            return null;
        }
    }
}
