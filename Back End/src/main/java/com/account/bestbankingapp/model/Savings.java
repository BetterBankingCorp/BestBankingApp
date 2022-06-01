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
		accountNum = "1" + accountNum;
		
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Savings [rate = " + rate + " , accountNum = " + "]";
	}

}
