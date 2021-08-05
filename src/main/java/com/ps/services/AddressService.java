package com.ps.services;

import com.ps.DTO.AddressDTO;
import com.ps.entities.AddressEntity;

public interface AddressService {
    public AddressDTO getAddressByPersonId(int personId);
}
