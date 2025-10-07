package com.eatexpress.app.order.domain;

import com.eatexpress.app.common.domain.Address;
import com.eatexpress.app.common.domain.Email;
import java.util.UUID;

public class ContactInfo {

    private UUID contactInfoId;

    private String firstName;
    private String lastName;
    private Email email;
    private Address address;

    public ContactInfo(
        String firstName,
        String lastName,
        Email email,
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UUID getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(UUID contactInfoId) {
        this.contactInfoId = contactInfoId;
    }
}
