package com.bms.authserver.service;

import com.bms.authserver.dao.AccountDetailRepository;
import com.bms.authserver.dao.CustomerCredentialsRepository;
import com.bms.authserver.dao.CustomerDetailRepository;
import com.bms.authserver.models.AccountDetail;
import com.bms.authserver.models.CustomerCredentials;
import com.bms.authserver.models.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class CustomerCredentialService {

    @Autowired
    private CustomerCredentialsRepository customerCredentialsRepository;
    @Autowired
    private CustomerDetailRepository customerDetailRepository;


    public ResponseEntity<CustomerDetail> getAccountDetails(String key){

        Optional<CustomerCredentials> customerCredentials = customerCredentialsRepository.findByLoggedInKey(key);

        if(!customerCredentials.isPresent()){
          throw new IllegalStateException("User not found");
        }

        Optional<CustomerDetail> customerDetail = customerDetailRepository.findByCustomerCredentialsId(customerCredentials.get().getId());


        if(!customerCredentials.isPresent()){
            throw new IllegalStateException("User not found");
        }

       return ResponseEntity
                .status(HttpStatus.OK).body(customerDetail.get());

    }
}
