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
import org.hibernate.annotations.Type;



@Entity
@Table(name="customer_address")
public class CustomerAddress extends Auditable<String> {

	@Id
	@Column(name="address_id")
	@GenericGenerator(strategy = "native",name = "native")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	private Long addressId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private CustomerDetail customerDetail;

	@Column(name="address",length = 100)
	@Size(max=100)
	private String address;

	@Column(name="city",length = 20)
	@Size(max=20)
	private String city;

	@Column(name="state",length = 20)
	@Size(max=20)
	private String state;

	@Column(name="pin_code",length = 6)
	@Size(max=6)
	private String pinCode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="is_active")
	private String isActive;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public CustomerAddress() {}

	public CustomerAddress(CustomerDetail customerDetail,String address,  String city,
			String state, String pinCode,  String country,
			String isActive) {
		super();
		this.customerDetail = customerDetail;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.country = country;
		this.isActive = isActive;
	}
	

}
