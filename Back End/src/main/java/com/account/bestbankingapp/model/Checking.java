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
		private int debitCardPin;
		
		public Checking() {
			
		}
		
		public Checking(String name, String ssn, double balance, double rate, String accountNum, long debitCardNumber,
				int debitCardPin) {
			super(name, ssn, balance, rate, accountNum);
			this.debitCardNumber = debitCardNumber;
			this.debitCardPin = debitCardPin;
		}

		public long getDebitCardNumber() {
			return debitCardNumber;
		}

		public void setDebitCardNumber(long debitCardNumber) {
			this.debitCardNumber = debitCardNumber;
		}

		public int getDebitCardPin() {
			return debitCardPin;
		}

		public void setDebitCardPin(int debitCardPin) {
			this.debitCardPin = debitCardPin;
		}

		@Override
		public String toString() {
			return "Checking [debitCardNumber=" + debitCardNumber + ", debitCardPin=" + debitCardPin + ", rate=" + rate
					+ ", accountNum=" + accountNum + "]";
		}
		
		

}

