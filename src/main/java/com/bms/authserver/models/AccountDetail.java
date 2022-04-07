package com.bms.authserver.models;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="account_details")
public class AccountDetail extends Auditable<String> {

	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(strategy = "native",name = "native")
	private Long accountId;

	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name="customer_id")
	private CustomerDetail customerDetail;
	
	@Column(name="account_number",unique = true,nullable = false)
	@Size(max=13)
	private String accountNumber;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="account_type_id")
	private AccountMaster accountTypeId;

	public AccountDetail(CustomerDetail customerDetail,  String accountNumber, AccountMaster accountTypeId) {
		super();
		this.customerDetail = customerDetail;
		this.accountNumber = accountNumber;
		this.accountTypeId = accountTypeId;
	}

	public AccountDetail() {}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}


	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public AccountMaster getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(AccountMaster accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	
	
	
	
	

}
