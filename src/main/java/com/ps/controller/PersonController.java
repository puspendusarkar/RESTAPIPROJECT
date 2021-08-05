package com.ps.controller;

import com.ps.DTO.PersonDTO;
import com.ps.entities.PersonEntity;
import com.ps.exception.ErrorCode;
import com.ps.exception.ResourceNotFoundException;
import com.ps.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonService personService;
    @GetMapping("/ssn/{personssn}")
    public ResponseEntity<PersonDTO> getPersonbySSN(@PathVariable String personssn) {
        PersonDTO personDTO = new PersonDTO();
        PersonEntity personEntity = personService.retrivePersonBySSN(personssn);
        logger.debug("personEntity"+personEntity);

        if (personEntity != null) {
            personDTO.setPersonID(personEntity.getPerson_id());
            personDTO.setFirstName(personEntity.getPerson_first_name());
            personDTO.setLastName(personEntity.getPerson_last_name());
            personDTO.setGender(personEntity.getPerson_gender());
            personDTO.setDateOfBirth(personEntity.getPerson_dob());
            personDTO.setPersonAddress(personEntity.getAddressEntity());
            logger.debug("persondto in service impl" + personDTO);

        }
        else{
            throw new ResourceNotFoundException("Person not found",ErrorCode.HTTP_RESOURCE_NOT_FOUND_EXCEPTION);
        }
        return new ResponseEntity<PersonDTO>(personDTO, HttpStatus.OK);

    }

}
