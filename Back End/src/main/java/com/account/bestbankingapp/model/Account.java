package com.account.bestbankingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public abstract class Account implements IBaseRate {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="id")
	private String name;
	@Column
	private String ssn;
	@Column
	private  double balance;
	@Column
	protected double rate;
	@Column
	protected String accountNum;
	@Column
	private static int index = 10000;
	
	
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
	public Account(String name, String ssn, double balance, double rate, String accountNum) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.balance = balance;
		this.rate = rate;
		this.accountNum = accountNum;
	}

	public Account() {
		
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", ssn=" + ssn + ", balance=" + balance + ", rate=" + rate + ", accountNum="
				+ accountNum + "]";
	}
	
	
}
	
