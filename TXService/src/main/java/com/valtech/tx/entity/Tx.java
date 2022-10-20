package com.valtech.tx.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tx {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float amount;
	private boolean debit;
	private LocalDate txTime;
	private long accountId;

	@Override
	public String toString() {
		return "Tx [id=" + id + ", amount=" + amount + ", debit=" + debit + ", accountId=" + accountId + "]";
	}

	public Tx(float amount, boolean debit, LocalDate txTime, long accountId) {
		super();
		this.amount = amount;
		this.debit = debit;
		this.txTime = txTime;
		this.accountId = accountId;
	}
	
	public Tx(float amount, boolean debit, long accountId) {
		super();
		this.amount = amount;
		this.debit = debit;
		this.txTime = LocalDate.now();
		this.accountId = accountId;
	}
	
	public Tx(float amount, long accountId) {
		super();
		this.amount = amount;
		this.debit = true;
		this.txTime = LocalDate.now();
		this.accountId = accountId;
	}

	public Tx(long id, float amount, boolean debit, LocalDate txTime, long accountId) {
		super();
		this.id = id;
		this.amount = amount;
		this.debit = debit;
		this.txTime = txTime;
		this.accountId = accountId;
	}

	public Tx() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tx(int id2, float amount2, boolean debit2, long accountId2) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id2;
		this.amount = amount2;
		this.debit = debit2;
		this.txTime = LocalDate.now();
		this.accountId = accountId2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public boolean isDebit() {
		return debit;
	}

	public void setDebit(boolean debit) {
		this.debit = debit;
	}

	public LocalDate getTxTime() {
		return txTime;
	}

	public void setTxTime(LocalDate localDate) {
		this.txTime = localDate;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

}
