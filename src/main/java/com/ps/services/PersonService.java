package com.ps.services;
import com.ps.entities.PersonEntity;
import org.springframework.stereotype.Service;

public interface PersonService {
    public PersonEntity addPerson(PersonEntity personEntity);
    public PersonEntity updatePerson(PersonEntity personEntity);
    public  PersonEntity retrivePersonBySSN(String personSSN);
    public  PersonEntity retrivePersonByID(Integer personID);
}
