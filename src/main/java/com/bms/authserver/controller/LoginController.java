package com.bms.authserver.controller;

import java.security.MessageDigest;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.bms.authserver.models.AccountDetail;
import com.bms.authserver.service.CustomerCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.dao.LoginRepository;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.models.CustomerDetail;
import com.bms.authserver.pojo.LoginRequest;
import com.bms.authserver.pojo.ResponseData;
import com.bms.authserver.util.CommonUtils;



@CrossOrigin(origins = "https://localhost:9090")
@RestController
public class LoginController {
	
	@Autowired
	CustomerCredentialsRepository customerCredentialsrepository;

	@Autowired
	private CustomerCredentialService customerCredentialService;
	@PostConstruct
	public void postConstruct() {
		CustomerCredentials cutomerCredential  = new CustomerCredentials();
		cutomerCredential.setUsername("rahul2022");
		cutomerCredential.setPassword("Pass@390");	
		customerCredentialsrepository.save(cutomerCredential);
		}
	
	@PostMapping ("/login")
	
	public <ResponseEntity>ResponseData login(@RequestBody LoginRequest loginRequest) { 
	CustomerCredentials customercredentials =customerCredentialsrepository.findByUsername(loginRequest.getUsername());
	
	if(Objects.nonNull(customercredentials)) {
		//String inputpassword=CommonUtils.bcryptPasswordEncoder(loginRequest.getPassword());
		if(loginRequest.getPassword().equals(customercredentials.getPassword())) {
			System.out.println("Login Successful");
			
		customercredentials.setLoggedInKey(String.valueOf(Math.random()));
		customerCredentialsrepository.save(customercredentials);
			ResponseData response =  new ResponseData(loginRequest.getUsername(),"success", 200, "Login successful");
			return response;
		}
	
		
	}
	ResponseData response =  new ResponseData("Failure", 400, "Invalid username and password");
	return response;
}


	
@PostMapping(path = "/logout/{username}")
public <ResponseEntity> ResponseData logoutUser(@PathVariable(name="username") String username) {
	
CustomerCredentials customerCredential =  customerCredentialsrepository.findByUsername(username);

if(Objects.isNull(customerCredential)) {
	//return ResponseEntity.ok().build();	
	
	ResponseData response =  new ResponseData("Failure", 400, "no user present");
	return response;

}
if(Objects.nonNull(customerCredential.getLoggedInKey()))
{
	customerCredential.setLoggedInKey(null);
	customerCredentialsrepository.save(customerCredential);
	
	
}
	//return ResponseEntity.ok().build();	
	
	ResponseData response =  new ResponseData(username,"success", 200, "Logout successful");
	return response;


}

	@GetMapping("/check/authorize/{key}/key")
	public ResponseEntity<CustomerDetail> checkUserAuthorization(@PathVariable(name = "key") String key){

		return customerCredentialService.getAccountDetails(key);
	}
}

	
	
