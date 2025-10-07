package com.eatexpress.app.order.adapter.out.db;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;

@Entity
@Table(schema = "ordering", name = "contact_infos")
public class ContactInfoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID contactInfoId;

    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private AddressJpaEntity address;

    public ContactInfoJpaEntity() {}

    public ContactInfoJpaEntity(
        UUID contactInfoId,
        String firstName,
        String lastName,
        String email,
        AddressJpaEntity address
    ) {
        this.contactInfoId = contactInfoId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public UUID getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(UUID contactInfoId) {
        this.contactInfoId = contactInfoId;
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

    public AddressJpaEntity getAddress() {
        return address;
    }

    public void setAddress(AddressJpaEntity address) {
        this.address = address;
    }
}
