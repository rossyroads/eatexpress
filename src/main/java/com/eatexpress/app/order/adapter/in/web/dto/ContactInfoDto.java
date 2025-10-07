package com.eatexpress.app.order.adapter.in.web.dto;

import com.eatexpress.app.common.domain.Address;

public class ContactInfoDto {

    private String firstName;
    private String lastName;
    private String email;
    private Address address;

    public ContactInfoDto(
        String firstName,
        String lastName,
        String email,
        Address address
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
