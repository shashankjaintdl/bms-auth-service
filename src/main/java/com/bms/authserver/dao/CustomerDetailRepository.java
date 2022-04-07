package com.bms.authserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.authserver.models.CustomerDetail;

import java.util.Optional;


@Repository
public interface CustomerDetailRepository extends JpaRepository<CustomerDetail, Long>{
    Optional<CustomerDetail> findByCustomerCredentialsId(Long id);
}
