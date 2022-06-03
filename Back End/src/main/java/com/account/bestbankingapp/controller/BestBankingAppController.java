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
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/accounts/savings", method=RequestMethod.POST)
	public Savings createSavings(@RequestBody Savings savingsAccount) {
	    return accountService.createSavingsAccount(savingsAccount);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/accounts/checking", method=RequestMethod.POST)
	public Checking createChecking(@RequestBody Checking checkingAccount) {
	    return accountService.createCheckingAccount(checkingAccount);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/accounts", method=RequestMethod.GET)
	public List<Account> readAccounts() {
	    return accountService.getAccounts();
	}
	
	@CrossOrigin(origins = "*")
	@PatchMapping("/accounts/{accountNum}")
	public Account patchAccount(@PathVariable(value = "accountNum") String accountNum, @PathVariable(value = "newname") String newName) {
		return accountService.patchAccount(accountNum, newName);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/accounts/{accountNum}", method=RequestMethod.DELETE)
	public void deleteAccount(@PathVariable(value = "accountNum") String accountNum) {
		accountService.deleteAccount(accountNum);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/accounts/savings/{accountNum}", method=RequestMethod.PUT)
	public Account readAccounts(@PathVariable(value = "accountNum") String AccountNum, @RequestBody Savings accountDetails) {
	    return accountService.updateSavingsAccount(AccountNum, accountDetails);
	}
	
	@CrossOrigin(origins = "*")
	@PatchMapping("/accounts/deposit/{accountNum}/{depositAmount}")
	public Account depositAccount(@PathVariable(value = "accountNum") String accountNum,  @PathVariable(value = "depositAmount") double depositAmount) {
		return accountService.depositAccount(accountNum, depositAmount);
	}
	
	@CrossOrigin(origins = "*")
	@PatchMapping("/accounts/withdraw/{accountNum}/{withdrawAmount}")
	public Account withdrawAccount(@PathVariable(value = "accountNum") String accountNum,  @PathVariable(value = "withdrawAmount") double withdrawAmount) {
		return accountService.withdrawAccount(accountNum, withdrawAmount);
	}
	
}


