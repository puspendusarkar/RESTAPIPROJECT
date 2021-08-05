package com.ps.services;

import com.ps.DTO.AddressDTO;
import com.ps.entities.AddressEntity;
import com.ps.exception.ErrorCode;
import com.ps.exception.ResourceNotFoundException;
import com.ps.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{
    private final Logger logger=LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AddressRepository addressRepository;
    public AddressDTO getAddressByPersonId(int personId) {
        AddressEntity addressEntity;
        AddressDTO addressDTO = new AddressDTO();
        addressEntity = addressRepository.getAddressByPersonId(personId);
        if (addressEntity != null){
        //addressDTO.setPersonName(addressEntity.getPersonEntity().getPerson_first_name() + " " +
       // addressEntity.getPersonEntity().getPerson_last_name());
        addressDTO.setPersonAddressLine1(addressEntity.getAddress_line1());
        addressDTO.setPersonAddressLine2(addressEntity.getAddress_line2());
        addressDTO.setPersonCityName(addressEntity.getCity());
        addressDTO.setPersonZipcode(addressEntity.getZipcode());
        addressDTO.setPersonCountryName(addressEntity.getCountry());
        //logger.debug(""+addressEntity);
        }
        else{
            throw new ResourceNotFoundException("Address not found", ErrorCode.HTTP_RESOURCE_NOT_FOUND_EXCEPTION);
        }

        logger.debug(".............."+addressDTO);
        return addressDTO;
    }
}
