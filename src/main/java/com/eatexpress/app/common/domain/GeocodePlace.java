package com.eatexpress.app.common.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocodePlace {

    private long place_id;
    private String licence;
    private String osm_type;
    private long osm_id;
    private Double[] boundingbox;
    private Double lat;
    private Double lon;
    private String display_name;

    @JsonProperty("class")
    private String place_class;

    private String type;
    private Double importance;

    public GeocodePlace(
        long place_id,
        String licence,
        String osm_type,
        long osm_id,
        Double[] boundingbox,
        Double lat,
        Double lon,
        String display_name,
        String place_class,
        String type,
        Double importance
    ) {
        this.place_id = place_id;
        this.licence = licence;
        this.osm_type = osm_type;
        this.osm_id = osm_id;
        this.boundingbox = boundingbox;
        this.lat = lat;
        this.lon = lon;
        this.display_name = display_name;
        this.place_class = place_class;
        this.type = type;
        this.importance = importance;
    }

    public long getPlace_id() {
        return place_id;
    }

    public void setPlace_id(long place_id) {
        this.place_id = place_id;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getOsm_type() {
        return osm_type;
    }

    public void setOsm_type(String osm_type) {
        this.osm_type = osm_type;
    }

    public long getOsm_id() {
        return osm_id;
    }

    public void setOsm_id(long osm_id) {
        this.osm_id = osm_id;
    }

    public Double[] getBoundingbox() {
        return boundingbox;
    }

    public void setBoundingbox(Double[] boundingbox) {
        this.boundingbox = boundingbox;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getPlace_class() {
        return place_class;
    }

    public void setPlace_class(String place_class) {
        this.place_class = place_class;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getImportance() {
        return importance;
    }

    public void setImportance(Double importance) {
        this.importance = importance;
    }
}
