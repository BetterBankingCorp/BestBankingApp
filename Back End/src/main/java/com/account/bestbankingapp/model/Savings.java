package com.account.bestbankingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.account.bestbankingapp.model.Account;

@Entity
//@Table(name = "account")
public class Savings extends Account {
	@Column(name = "safetyDepositBoxID") 
	private int safetyDepositBoxID;
	@Column(name = "safetyDepositBoxKey")
	private int safetyDepositBoxKey;
	
	
	public Savings(String name, String ssn, double balance, String memberId, String password) {
		super(name, ssn, balance, memberId, password);
		setSafetyDepositBox();
	}
	
	public Savings() {
		
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
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
	
	//Randomizer to set safety deposit box numbers
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	@Override
	public String toString() {
		return "Savings [safetyDepositBoxID=" + safetyDepositBoxID + ", safetyDepositBoxKey=" + safetyDepositBoxKey
				+ ", rate=" + rate + ", accountNum=" + accountNum + "]";
	}
	
	

}

