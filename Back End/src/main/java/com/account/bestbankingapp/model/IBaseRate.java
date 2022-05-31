package com.account.bestbankingapp.model;

public interface IBaseRate {
	
		default double getBaseRate() {
			return 2.5;
		}

}
