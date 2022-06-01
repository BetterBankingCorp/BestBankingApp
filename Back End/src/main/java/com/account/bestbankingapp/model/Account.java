package com.account.bestbankingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public abstract class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// Attributes
	@Column
	private String SSN;
	@Column
	protected String accountNum;
	@Column
	private double balance;
	@Column
	protected String name;
	@Column
	private static int index = 10000;

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return SSN;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNum() {
		return accountNum;
	}

	// Constructors
	public Account(String name, String SSN, double initDeposit) {
		this.name = name;
		this.SSN = SSN;
		balance = initDeposit;

		index++;
		this.accountNum = setAccountNumber();
	}

	public Account() { }

	// Determines each person's account number
	private String setAccountNumber() {
		String lastTwoOfSSN = SSN.substring(SSN.length() - 2, SSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}


}
