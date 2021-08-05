package com.ps;

import com.ps.DTO.AddressDTO;
import com.ps.DTO.PersonDTO;
import com.ps.exception.BusinessException;
import com.ps.services.AddressService;
import com.ps.services.PersonService;
import com.ps.services.PersonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ServiceApplication implements CommandLineRunner {
	@Autowired
	private PersonService personService;
	@Autowired
	private AddressService addressService;
	private final Logger logger= LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);

	}

	@Override
	public void run(String... args) {
		//PersonService personService=new PersonServiceImpl();
		try {
			addressService.getAddressByPersonId(2);
			logger.debug("in main"+personService.retrivePersonBySSN("267453231"));
			}
		catch (RuntimeException ex){
			logger.error(ex.getMessage());
		}

	}
}
