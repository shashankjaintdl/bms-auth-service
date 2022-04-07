package com.bms.authserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.authserver.models.AccountMaster;

public interface AccountMasterRepository extends JpaRepository<AccountMaster, Long>{

}
