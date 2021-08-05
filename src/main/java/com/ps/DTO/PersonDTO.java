package com.ps.DTO;

import com.ps.entities.AddressEntity;

import java.util.Date;

public class PersonDTO {
    private Integer personID;
    private String firstName;
    private  String lastName;
    private Date dateOfBirth;
    private  Date dateOfDeth;
    private String gender;
    private  String ssn;
    private AddressEntity personAddress;

    public AddressEntity getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(AddressEntity personAddress) {
        this.personAddress = personAddress;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfDeth() {
        return dateOfDeth;
    }

    public void setDateOfDeth(Date dateOfDeth) {
        this.dateOfDeth = dateOfDeth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "personID=" + personID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeth=" + dateOfDeth +
                ", gender='" + gender + '\'' +
                ", ssn='" + ssn + '\'' +
                ", addressEntity=" + personAddress +
                '}';
    }
}
