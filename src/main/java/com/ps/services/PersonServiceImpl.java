package com.ps.services;

import com.ps.DTO.PersonDTO;
import com.ps.entities.PersonEntity;
import com.ps.exception.BusinessException;
import com.ps.exception.ErrorCode;
import com.ps.exception.ResourceNotFoundException;
import com.ps.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonEntity addPerson(PersonEntity personEntity) {
        return null;
    }

    @Override
    public PersonEntity updatePerson(PersonEntity personEntity) {
        return null;
    }

    @Override
    public PersonEntity retrivePersonBySSN(String personSSN) throws RuntimeException {
        /**
        PersonEntity personEntity;
        PersonDTO personDTO=new PersonDTO();
        personEntity=personRepository.getPersonBySSN(personSSN);
      logger.debug("PersonEntity"+personEntity);
       if(personEntity!=null){
           personDTO.setFirstName(personEntity.getPerson_first_name());
           personDTO.setLastName(personEntity.getPerson_last_name());
           personDTO.setGender(personEntity.getPerson_gender());
           personDTO.setDateOfBirth(personEntity.getPerson_dob());
           personDTO.setAddressEntity(personEntity.getAddressEntity());
           logger.debug("persondto in service impl"+personDTO);

        }
       else{
           throw new ResourceNotFoundException("Person doesn't exits", ErrorCode.HTTP_RESOURCE_NOT_FOUND_EXCEPTION);

       }
         **/
        logger.debug("retrivePersonBySSN" +personRepository.getPersonBySSN(personSSN));
       return personRepository.getPersonBySSN(personSSN);

    }

    @Override
    public PersonEntity retrivePersonByID(Integer personID) {
        return null;
    }
}
