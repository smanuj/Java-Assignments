package com.valtech.account.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	public static final String SAVINGS = "SB";
	public static final String CURRENT = "CA";

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;
	private String accountType;
	private double balance;
	private LocalDate dateOfCreation;
	private LocalDate lastUpdatedDate;
	private boolean active;

	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", balance=" + balance + ", dateOfCreation="
				+ dateOfCreation + ", lastUpdatedDate=" + lastUpdatedDate + ", active=" + active + "]";
	}



	public Account(long id, String accountType, double balance, LocalDate dateOfCreation, LocalDate lastUpdatedDate,
			boolean active) {
		super();
		this.id = id;
		this.accountType = accountType;
		this.balance = balance;
		this.dateOfCreation = dateOfCreation;
		this.lastUpdatedDate = lastUpdatedDate;
		this.active = active;
	}
	
	

	public Account(String accountType, double balance) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.dateOfCreation = LocalDate.now();
		this.lastUpdatedDate = LocalDate.now();
		this.active = false;
	}



	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(LocalDate dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public LocalDate getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
