package com.bms.authserver.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bms.authserver.models.CustomerAddress;


@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long>{

}
