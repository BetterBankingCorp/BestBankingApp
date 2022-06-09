package com.account.bestbankingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.account.bestbankingapp.model.Account;
import com.account.bestbankingapp.model.IBaseRate;

@Entity
@Table(name = "account")
public abstract class Account implements IBaseRate {
	
	//@Id
	//@GeneratedValue(strategy =GenerationType.IDENTITY)
	//@Column(name="id")
	//protected Long id;
	@Column
	private String name;
	@Column
	private String ssn;
	@Column
	private  double balance;
	@Column
	protected double rate;
	@Id
	@Column
	protected String accountNum;
	@Column
	private String memberId;
	@Column
	private String password;
	@Column
	protected static int index = 10000;
	
	//public Long getId() {
		//return id;
	//}
public Account() {		
	}

public Account(String name, String ssn, double balance, String memberId, String password) {
	super();
	this.name = name;
	this.ssn = ssn;
	this.balance = balance;
	this.memberId = memberId;
	this.password = password;
	
	index++;
	this.accountNum = setAccountNumber();
	
	setRate();
}

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
	public String setAccountNumber() {
		String lastTwoOfSSN = ssn.substring(ssn.length() - 2, ssn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	public static int getIndex() {
		return index;
	}
	public static void setIndex(int index) {
		Account.index = index;
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNextAccountNumber(){
		return index++;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	//Abstract method to set interest rate
	public abstract void setRate();
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", ssn=" + ssn + ", balance=" + balance + ", rate=" + rate + ", accountNum="
				+ accountNum + "]";
	}
		
}