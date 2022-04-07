package com.bms.authserver.controller;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bms.authserver.models.CustomerCredentials;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
public class LoginControllerTest extends AbstractTest {

	@Test
	
	public void createCustomerLogin() throws Exception {
	String uri = "/login";
	CustomerCredentials customercredentials = new CustomerCredentials();
	customercredentials.setUsername("Rahul2022");
	customercredentials.setPassword("Pass@2022");
	String inputJson = super.mapToJson(customercredentials);
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	int status = mvcResult.getResponse().getStatus();
	assertEquals(200, status);
	String content = mvcResult.getResponse().getContentAsString();
	assertEquals(content, "Login successfully");

}
	
	@Test
	public void checkByUsername() throws Exception {
	String uri = "/login";
	CustomerCredentials customercredentials = new CustomerCredentials();
	customercredentials.setUsername("jack2022");
	customercredentials.setPassword("Pass@390");
	String inputJson = super.mapToJson(customercredentials);
	System.out.println("MVC obj "+mvc);
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	int status = mvcResult.getResponse().getStatus();
	assertEquals(400, status);
	String content = mvcResult.getResponse().getContentAsString();
	assertEquals(content, "Incorrect username");

}
	
	@Test
	public void checkPassword() throws Exception {
	String uri = "/login";
	CustomerCredentials customercredentials = new CustomerCredentials();
	customercredentials.setUsername("Rahul2022");
	customercredentials.setPassword("Pass000");
	String inputJson = super.mapToJson(customercredentials);
	MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	int status = mvcResult.getResponse().getStatus();
	assertEquals(400, status);
	String content = mvcResult.getResponse().getContentAsString();
	assertEquals(content, "Incorrect password");

}
	
	@Test
	public void LogoutUser() throws Exception {
	   String uri = "/logout";
	   CustomerCredentials customercredentials = new CustomerCredentials();
		customercredentials.setUsername("Rahul2022");
		String inputJson = super.mapToJson(customercredentials);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
	   assertEquals(200, "Logout successfully");
	  
	}



}
