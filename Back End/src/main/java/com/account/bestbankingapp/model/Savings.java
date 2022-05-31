package com.account.bestbankingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Savings extends Account implements IBaseRate {

	@Column
	protected double rate;

	public Savings() {
	}

	public Savings(String name, String ssn, double balance) {
		super(name, ssn, balance);
		accountNumber = "1" + accountNumber;
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Savings [safetyDepositBoxID=" + safetyDepositBoxID + ", safetyDepositBoxKey=" + safetyDepositBoxKey
				+ ", rate=" + rate + ", accountNum=" + accountNum + "]";
	}

}
