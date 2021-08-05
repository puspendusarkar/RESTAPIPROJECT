package com.ps.DTO;

import java.io.Serializable;

public class AddressDTO implements Serializable {
    private String personName;
    private String personAddressLine1;
    private String personAddressLine2;
    private String personCityName;
    private String personZipcode;
    private String personCountryName;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAddressLine1() {
        return personAddressLine1;
    }

    public void setPersonAddressLine1(String personAddressLine1) {
        this.personAddressLine1 = personAddressLine1;
    }

    public String getPersonAddressLine2() {
        return personAddressLine2;
    }

    public void setPersonAddressLine2(String personAddressLine2) {
        this.personAddressLine2 = personAddressLine2;
    }

    public String getPersonCityName() {
        return personCityName;
    }

    public void setPersonCityName(String personCityName) {
        this.personCityName = personCityName;
    }

    public String getPersonZipcode() {
        return personZipcode;
    }

    public void setPersonZipcode(String personZipcode) {
        this.personZipcode = personZipcode;
    }

    public String getPersonCountryName() {
        return personCountryName;
    }

    public void setPersonCountryName(String personCountryName) {
        this.personCountryName = personCountryName;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "personName='" + personName + '\'' +
                ", personAddressLine1='" + personAddressLine1 + '\'' +
                ", personAddressLine2='" + personAddressLine2 + '\'' +
                ", personCityName='" + personCityName + '\'' +
                ", personZipcode='" + personZipcode + '\'' +
                ", personCountryName='" + personCountryName + '\'' +
                '}';
    }
}
