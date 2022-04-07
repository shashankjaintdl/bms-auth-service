package com.bms.authserver.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "account_master")
public class AccountMaster {
	
	@Id
	@Column(name="account_type_id")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
	private Long accountTypeId;
	
	
	@Column(name="account_type")
	@Size(max=50)
	private String accountType;

	
	public Long getAccountTypeId() {
		return accountTypeId;
	}


	public void setAccountTypeId(Long accountTypeId) {
		this.accountTypeId = accountTypeId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public AccountMaster() {}


	public AccountMaster( String accountType) {
		super();
		this.accountType = accountType;
	}
	
}
