package com.bms.authserver.pojo;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegistrationData {
	
	@NotBlank(message = "Username cannot be empty..")
	String username;
	
	@NotBlank(message = "Password cannot be empty..")
	String password;
	
	@NotBlank(message = "firestname cannot be empty..")
	String firstName;
	
	@NotBlank(message = "Lastname cannot be empty..")
	String lastName;
	
	@NotBlank
	String email;
	
	@NotBlank(message = "gender cannot be empty..")
	String gender;
	
	@NotBlank
	String dob;
	
	@NotBlank(message = "Contact no cannot be empty..")
	String contact;
	
	@NotBlank(message = "pan cannot be empty..")
	String pan;
	
	@NotBlank(message = "address cannot be empty..")
	String address;
	
	@NotBlank(message = "city cannot be empty..")
	String city;
	
	@NotBlank(message = "state cannot be empty..")
	String state;
	
	@NotBlank(message = "country cannot be empty..")
	String country;
	
	@NotNull
	int pincode;
	
	String accountType;
	
	public RegistrationData(){}
	public RegistrationData(String username,
			String password,
			 String firstName,
			 String lastName, String email,
			String gender, 
			String dob,
			 String contact,
			 String pan,
			 String address,
			 String city,
			 String state,
			 String country,
			 int pincode,
			 String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.contact = contact;
		this.pan = pan;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.accountType = accountType;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public  String getDob() {
		return dob;
	}


	public void setDob( String dob) {
		this.dob = dob;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getPan() {
		return pan;
	}


	public void setPan(String pan) {
		this.pan = pan;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	
	
	
	
	

}
