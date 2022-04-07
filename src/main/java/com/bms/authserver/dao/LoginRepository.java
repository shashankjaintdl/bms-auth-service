package com.bms.authserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.models.CustomerDetail;

@Repository
public interface LoginRepository extends JpaRepository<CustomerDetail, Long> {

	//CustomerDetail findByUsername(String username);

	

	
	

}