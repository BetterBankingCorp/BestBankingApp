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
	private String ssn;
	@Column
	private long accountNum;
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
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		Account.index = index;
	}

	// Constructors
	public Account(String name, String SSN, double initDeposit) {
		this.name = name;
		this.SSN = SSN;
		balance = initDeposit;

		index++;
		this.accountNumber = setAccountNumber();

		setRate();
	}

	public Account() {

	}

	// Determines each person's account number
	private long setAccountNumber() {
		String lastTwoOfSSN = SSN.substring(SSN.length() - 2, SSN.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", ssn=" + ssn + ", balance=" + balance + ", rate=" + rate + ", accountNum="
				+ accountNum + "]";
	}

}
