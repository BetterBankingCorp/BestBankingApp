package com.account.bestbankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.bestbankingapp.model.Account;
import com.account.bestbankingapp.model.Checking;
import com.account.bestbankingapp.model.IBaseRate;
import com.account.bestbankingapp.model.Savings;
import com.account.bestbankingapp.repository.BestBankingAppRespository;


import java.util.List;
import java.util.Optional;

@Service
public class BestBankingAppService {
	@Autowired
	BestBankingAppRespository accountRepository;

	//create savings account
	public Savings createSavingsAccount(Savings savingsAccount) {
		savingsAccount.setAccountNum("Savings-" + savingsAccount.getNextAccountNumber());
		return accountRepository.save(savingsAccount);
	}
	//create checking account
	public Checking createCheckingAccount(Checking checkingAccount) {
		checkingAccount.setAccountNum("Checking-" + checkingAccount.getNextAccountNumber());
		return accountRepository.save(checkingAccount);
	}
	
	//read accounts
	public List<Account> getAccounts() {
	    return accountRepository.findAll();
	}
	//delete accounts
	public void deleteAccount(String accountNum) {
		accountRepository.deleteById(accountNum);
	}
	
	//patch accounts
	public Account patchAccount(String accountNum, String newName) {
		Account account = accountRepository.findById(accountNum).get();
		account.setName(newName);
		return accountRepository.save(account);
	}
	
	//update account	
	public Account updateAccount(String accountNum, Account accountDetails) {
		Optional<Account> optionalAccount = accountRepository.findById(accountNum);	
		if(optionalAccount.isPresent()) {
			Account account=optionalAccount.get();
			account.setName(accountDetails.getName());
			account.setSsn(accountDetails.getSsn());
			account.setBalance(accountDetails.getBalance());
			 return accountRepository.save(account);  
		}
		else {
			return null;
		}
	}
}
