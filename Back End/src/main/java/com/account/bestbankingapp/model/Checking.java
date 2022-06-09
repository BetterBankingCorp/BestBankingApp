package com.account.bestbankingapp.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.account.bestbankingapp.model.Account;

@Entity
//@Table(name = "account")

public class Checking extends Account {
	
		@Column(name = "debitCardNumber")
		private long debitCardNumber;
		@Column(name = "debitCardPin")
		private int debitCardPIN;
		
		
		
		public Checking(String name, String ssn, double balance, String memberId, String password) {
			super(name, ssn, balance, memberId, password);
		}
		
		public Checking() { }

		public long getDebitCardNumber() {
			return debitCardNumber;
		}

		public void setDebitCardNumber(long debitCardNumber) {
			this.debitCardNumber = debitCardNumber;
		}
		
		public void setDebitCard() {
			debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
			debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
		}

		public int getDebitCardPin() {
			return debitCardPIN;
		}

		public void setDebitCardPin(int debitCardPin) {
			this.debitCardPIN = debitCardPin;
		}
		
		@Override
		public void setRate() {
			rate = getBaseRate() * 0.15;
		}

		@Override
		public String toString() {
			return "Checking [debitCardNumber=" + debitCardNumber + ", debitCardPin=" + debitCardPIN + ", rate=" + rate
					+ ", accountNum=" + accountNum + "]";
		}
		
		

}

