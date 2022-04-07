package com.bms.authserver.service;

import java.util.Date;
import java.util.Random;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.authserver.dao.AccountDetailRepository;
import com.bms.authserver.dao.CustomerAddressRepository;
import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.dao.CustomerDetailRepository;
import com.bms.authserver.models.AccountDetail;
import com.bms.authserver.models.AccountMaster;
import com.bms.authserver.models.CustomerAddress;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.models.CustomerDetail;
import com.bms.authserver.pojo.RegistrationData;
import com.bms.authserver.util.CommonUtils;

@Service
public class ControllerServiceJpa {
	

	@Autowired
	CustomerAddressRepository   customerAddressRepository;
	
	@Autowired
	AccountDetailRepository accountDetailRepository;
	
	
	public void registrationdatainsertion(RegistrationData obj) throws ParseException {
		
		CustomerCredentials cc= new CustomerCredentials(obj.getUsername(),CommonUtils.bcryptPasswordEncoder(obj.getPassword())); 
		CustomerDetail cd= new CustomerDetail(cc,obj.getFirstName(),obj.getLastName(),obj.getEmail(),obj.getGender(),(Date) new SimpleDateFormat("dd/MM/yyyy").parse(obj.getDob()),obj.getContact(),obj.getPan());
		CustomerAddress ca = new CustomerAddress(cd,obj.getAddress(),obj.getCity(),obj.getState(),String.valueOf(obj.getPincode()),obj.getCountry(),"active");
        AccountMaster am = new AccountMaster(obj.getAccountType());
        Random rand = new Random();
        AccountDetail ad = new AccountDetail(cd,String.valueOf(rand.nextInt((999999999 - 100) + 1) + 10),am);
        customerAddressRepository.save(ca);
        accountDetailRepository.save(ad);	
	}
}
