package com.account.bestbankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.bestbankingapp.model.Account;
import com.account.bestbankingapp.model.Checking;
import com.account.bestbankingapp.model.IBaseRate;
import com.account.bestbankingapp.model.Savings;
import com.account.bestbankingapp.repository.BestBankingAppRespository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BestBankingAppService {
	@Autowired
	BestBankingAppRespository accountRepository;

	//create savings account
	public Savings createSavingsAccount(Savings savingsAccount) {
		savingsAccount.setAccountNum("Savings - 1" + savingsAccount.setAccountNumber());
		return accountRepository.save(savingsAccount);
	}
	//create checking account
	public Checking createCheckingAccount(Checking checkingAccount) {
		checkingAccount.setAccountNum("Checking - 2" + checkingAccount.setAccountNumber());
		checkingAccount.setDebitCard();
		return accountRepository.save(checkingAccount);
	}
	
	//read accounts
	public List<Account> getAccounts() {
	    return accountRepository.findAll();
	}
	
	public List<Account> getAccountsByMemberID(String memberID, String password) {
		return accountRepository.findByMemberIDAndPass(memberID, password);
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
	public Account updateSavingsAccount(String accountNum, Savings accountDetails) {
		Optional<Account> optionalAccount = accountRepository.findById(accountNum);	
		
		if(optionalAccount.isPresent()) {
			Savings account=(Savings) optionalAccount.get();
			account.setName(accountDetails.getName());
			account.setSsn(accountDetails.getSsn());
			return accountRepository.save(account);  
		}
		else {
			return null;
		}

	}
	
	//deposit account
	public Account depositAccount(String accountNum, double depositAmount) {
		Optional<Account> optionalAccount = accountRepository.findById(accountNum);	
		
		if(optionalAccount.isPresent()) {
			Account account=optionalAccount.get();
			account.setBalance(account.getBalance() + depositAmount);
			return accountRepository.save(account);  
		}
		else {
			return null;
		}
	}
	
	//withdraw account
	public Account withdrawAccount(String accountNum, double withdrawAmount) {
		Optional<Account> optionalAccount = accountRepository.findById(accountNum);	
		
		if(optionalAccount.isPresent()) {
			Account account=optionalAccount.get();
			
			if(account.getBalance() >= withdrawAmount) { //Withdraw only if the balance is >= withdrawal amount
				account.setBalance(account.getBalance() - withdrawAmount);
				return accountRepository.save(account); 
			}
			else {
				return account;
			}
		}
		else {
			return null;
		}		
	}
	
	//transfer amount
	public List<Account> transferAmount(String fromAccountNum, String toAccountNum, double transferAmount) {
		Optional<Account> optionalFromAccount = accountRepository.findById(fromAccountNum);	
		Optional<Account> optionalToAccount = accountRepository.findById(toAccountNum);	
		if(optionalFromAccount.isPresent() && optionalToAccount.isPresent()) {
			Account fromAccount=optionalFromAccount.get();
			Account toAccount=optionalToAccount.get();
			List<Account> accounts = new ArrayList<Account>();
			accounts.add(fromAccount);
			accounts.add(toAccount);
			
			if(fromAccount.getBalance() >= transferAmount) {
				withdrawAccount(fromAccountNum, transferAmount);//Withdraw only if the balance is >= withdrawal amount
				depositAccount(toAccountNum,transferAmount );
				accountRepository.save(fromAccount);
				accountRepository.save(toAccount);				
			}
			return accounts;			
		}
		else {
			return null;
		}		
	}
}
