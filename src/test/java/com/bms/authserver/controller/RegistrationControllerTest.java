package com.bms.authserver.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
=======
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
>>>>>>> 0d41ccaf27a031d380b29617332062c4e86d1c30
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bms.authserver.AuthServerApplication;
import com.bms.authserver.pojo.RegistrationData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

<<<<<<< HEAD
@WebAppConfiguration
class RegistrationControllerTest {

	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	void registerTest1() throws Exception {
		String uri = "/emp/register";

		RegistrationData registrationData = new RegistrationData("ranjit", "aser@987", "ranjit", "jadhav",
				"ion@smair.com", "male", null, 9878, "ASJH1928J", "Abac chs", "mumbai", "maharashtra", "india", 400015,
				"loan");

		String inputJson = mapToJson(registrationData);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();

=======
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AuthServerApplication.class })
class RegistrationControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wc;
	static ObjectMapper MAPPER = new ObjectMapper();

	@Before
	public void setUp() throws JsonProcessingException, Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wc).build();
	}
	@Test
	public void customercredentialaTest1() throws JsonProcessingException, Exception {
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
        String json = MAPPER.writeValueAsString(obj);
		MvcResult andReturn = mockMvc
				.perform(MockMvcRequestBuilders.post("/register")
						.content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200)).andReturn();
		
>>>>>>> 0d41ccaf27a031d380b29617332062c4e86d1c30
	}
}
