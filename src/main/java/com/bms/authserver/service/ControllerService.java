package com.bms.authserver.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.pojo.RegistrationData;
import com.bms.authserver.pojo.ResponseData;
@Service
public class ControllerService {
	

	public ResponseData validationcheck( RegistrationData data) {
		
		ResponseData response = new ResponseData(data.getUsername(),"success",200,"successfully registered! ");
		String msg ="";
		boolean valid = true;
		if(usernameavailability(data.getUsername())) {
			
		  if(!isValidPassword(data.getPassword())) {
			  valid = false;
			  msg=msg+"password doesnt meet criteria! ";
		  }
		  if(!isValidEmailId(data.getEmail())) {
			  valid = false;
			  msg=msg+"please enter a valid email id! ";
		  }
			
		  if(!isValidPhoneNumber(data.getContact())) { valid = false;
			  msg=msg+"please enter a valid phone number! ";
		  }
			 
		  if(!isValidPanNumber(data.getPan())) {
			  valid = false;
			  msg=msg+"please enter a valid pan number! ";
		  }
		  if(!isValidPinCode(data.getPincode())) {
			  valid = false;
			  msg=msg+"please enter a valid pincode! ";
		  }
		  
			
		}
		else {
			response.setCode(400); 
			response.setMessage("username is not available");
			response.setStstus("failure");
		}
		
		
		if(valid==false) {
			response.setCode(400);
			response.setMessage(msg);
			response.setStstus("failure");
		}
		
		return response;
	}
	//function for checking username availability
	public static boolean usernameavailability(String username ) {
		if(username.contains("admin")) {
			return false;
		}
		return true;
	}
	//function for checking password criteria
	public static boolean isValidPassword(String password)
    {
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
  
        Pattern p = Pattern.compile(regex);
  
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }
	//function for validating email id
	public static boolean isValidEmailId(String email ) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
                  
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
          return false;
      
      return pat.matcher(email).matches();
	}
	//function for validating phone number
	public static boolean isValidPhoneNumber(String s) {
		
		Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
		
	}
	//function for pan number validation
	public static boolean isValidPanNumber(String panCardNo) {
		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(panCardNo);
        return m.matches();
	}
	//function to check pincode validation
	public static boolean isValidPinCode(int pincode1)
	{
	    String pincode = Integer.toString(pincode1);
	    Pattern p = Pattern.compile("^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$");
	    Matcher m = p.matcher(pincode);
        return m.matches();
	    
	}
}
