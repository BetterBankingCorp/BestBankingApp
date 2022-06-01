package com.account.bestbankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.account.bestbankingapp.model.Account;
import com.account.bestbankingapp.model.Checking;
import com.account.bestbankingapp.model.Savings;
import com.account.bestbankingapp.service.BestBankingAppService;

@RestController
@RequestMapping("/api")
public class BestBankingAppController {
	@Autowired
    BestBankingAppService accountService;
	
	@RequestMapping(value="/accounts/savings", method=RequestMethod.POST)
	public Savings createSavings(@RequestBody Savings savingsAccount) {
	    return accountService.createSavingsAccount(savingsAccount);
	}
	
	@RequestMapping(value="/accounts/checking", method=RequestMethod.POST)
	public Checking createChecking(@RequestBody Checking checkingAccount) {
	    return accountService.createCheckingAccount(checkingAccount);
	}
	
	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	public List<Account> readAccounts() {
	    return accountService.getAccounts();
	}
	
	@RequestMapping(value="/accounts/{accountId}", method=RequestMethod.DELETE)
	public void deleteAccount(@PathVariable(value = "accountId") Long id) {
		accountService.deleteAccount(id);
	}
	@RequestMapping(value="/accounts/{accountId}", method=RequestMethod.PUT)
	public Account readAccounts(@PathVariable(value = "accountId") Long id, @RequestBody Account accountDetails) {
	    return accountService.updateAccount(id, accountDetails);
	}
	

}


