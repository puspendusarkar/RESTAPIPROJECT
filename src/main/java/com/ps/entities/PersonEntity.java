package com.ps.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

@Entity(name="person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int person_id;
    private String person_first_name;
    private String person_last_name;
    private Date person_dob;
    private  Date person_dod;
    private String person_gender;
    private String person_ssn;

    @OneToOne(mappedBy = "personEntity",fetch = FetchType.LAZY)
    private AddressEntity addressEntity;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_first_name() {
        return person_first_name;
    }

    public void setPerson_first_name(String person_first_name) {
        this.person_first_name = person_first_name;
    }

    public String getPerson_last_name() {
        return person_last_name;
    }

    public void setPerson_last_name(String person_last_name) {
        this.person_last_name = person_last_name;
    }

    public Date getPerson_dob() {
        return person_dob;
    }

    public void setPerson_dob(Date person_dob) {
        this.person_dob = person_dob;
    }

    public Date getPerson_dod() {
        return person_dod;
    }

    public void setPerson_dod(Date person_dod) {
        this.person_dod = person_dod;
    }

    public String getPerson_gender() {
        return person_gender;
    }

    public void setPerson_gender(String person_gender) {
        this.person_gender = person_gender;
    }

    public String getPerson_ssn() {
        return person_ssn;
    }

    public void setPerson_ssn(String person_ssn) {
        this.person_ssn = person_ssn;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "person_id=" + person_id +
                ", person_first_name='" + person_first_name + '\'' +
                ", person_last_name='" + person_last_name + '\'' +
                ", person_dob=" + person_dob +
                ", person_dod=" + person_dod +
                ", person_gender='" + person_gender + '\'' +
                ", person_ssn='" + person_ssn + '\'' +
                ", addressEntity=" + addressEntity +
                '}';
    }
}
