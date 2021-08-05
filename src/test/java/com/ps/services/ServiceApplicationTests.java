package com.ps.services;

import com.ps.DTO.AddressDTO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTests {
	@Autowired
	AddressService addressService;


	@Test
	public void getAddressByPersonIdTest(){
		System.out.println("test");

		AddressDTO addressDTO=addressService.getAddressByPersonId(2);
		System.out.println(addressDTO);
		Assert.assertEquals("816 Summit Crest CT",addressDTO.getPersonAddressLine1());
	}


}
