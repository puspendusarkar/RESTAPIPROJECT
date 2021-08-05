package com.ps.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;

@Entity(name="address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int address_id;
    private String address_line1;
    private String address_line2;
    private String city;
    private String zipcode;
    private String country;
    private int person_id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="person_id", nullable = false,insertable=false, updatable=false)
    @JsonIgnore
    private PersonEntity personEntity;

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "address_id=" + address_id +
                ", address_line1='" + address_line1 + '\'' +
                ", address_line2='" + address_line2 + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country='" + country + '\'' +
                ", person_id=" + person_id +
               // ", personEntity=" + personEntity +
                '}';
    }
}
