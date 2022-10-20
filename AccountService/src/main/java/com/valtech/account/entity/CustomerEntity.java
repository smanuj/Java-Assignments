package com.valtech.account.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String mail;
	private String mobile;
	private LocalDate dob;
	private String address;
	private String customerType;
	private int pincode;
	
	

	public CustomerEntity(String name, String mail, String mobile, LocalDate dob, String address, String customerType,
			int pincode) {
		super();
		this.name = name;
		this.mail = mail;
		this.mobile = mobile;
		this.dob = dob;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}

	public CustomerEntity(int id, String name, String mail, String mobile, LocalDate dob, String address,
			String customerType, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.mobile = mobile;
		this.dob = dob;
		this.address = address;
		this.customerType = customerType;
		this.pincode = pincode;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
