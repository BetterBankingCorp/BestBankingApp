package com.account.bestbankingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Savings extends Account {
	@Column(name = "safetyDepositBoxID") 
	private int safetyDepositBoxID;
	@Column(name = "safetyDepositBoxKey")
	private int safetyDepositBoxKey;
	
	public Savings() {
		
	}
	
	public Savings(String name, String ssn, double balance, double rate, String accountNum, int safetyDepositBoxID,
			int safetyDepositBoxKey) {
		super(name, ssn, balance, rate, accountNum);
		this.safetyDepositBoxID = safetyDepositBoxID;
		this.safetyDepositBoxKey = safetyDepositBoxKey;
	}

	public int getSafetyDepositBoxID() {
		return safetyDepositBoxID;
	}

	public void setSafetyDepositBoxID(int safetyDepositBoxID) {
		this.safetyDepositBoxID = safetyDepositBoxID;
	}

	public int getSafetyDepositBoxKey() {
		return safetyDepositBoxKey;
	}

	public void setSafetyDepositBoxKey(int safetyDepositBoxKey) {
		this.safetyDepositBoxKey = safetyDepositBoxKey;
	}

	@Override
	public String toString() {
		return "Savings [safetyDepositBoxID=" + safetyDepositBoxID + ", safetyDepositBoxKey=" + safetyDepositBoxKey
				+ ", rate=" + rate + ", accountNum=" + accountNum + "]";
	}
	
	

}
