package com.bms.authserver.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.pojo.RegistrationData;

public class ControllerServiceJpaTest {

	@Autowired
    ControllerServiceJpa controllerServiceJpa;
	
	@Test
	public void insertiontest1() throws ParseException{
		RegistrationData obj = new RegistrationData();
		obj.setAccountType("savings");
		obj.setAddress("main road,duddenapally");
		obj.setCity("karimnagar");
		obj.setContact("9177144155");
		obj.setCountry("india");
		obj.setDob("10/10/1999");
		obj.setEmail("rohithshiv@gmail.com");
		obj.setFirstName("rajeshwar");
        obj.setGender("male");
        obj.setLastName("shivanathri");
        obj.setPan("JBVPS5610D");
        obj.setPassword("Rohith@4282");
        obj.setPincode(505472);
        obj.setState("telangana");
        obj.setUsername("rohith4282");
		controllerServiceJpa.registrationdatainsertion(obj);
		
	}
}
