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
import org.springframework.web.bind.annotation.RestController;

import com.account.bestbankingapp.model.Account;
import com.account.bestbankingapp.model.Checking;
import com.account.bestbankingapp.model.Savings;
import com.account.bestbankingapp.service.BestBankingAppService;

//update
//controller
@RestController
@RequestMapping("/Best_BankingApp")
public class BestBankingAppController {
	@Autowired
    BestBankingAppService bestBankingAppService;

	//CREATE CHECKING ENTRY
    @PostMapping("/add-checking")
    public Account createChecking(@RequestBody Checking checking) {
   	 return bestBankingAppService.createCheckingAccount(checking);
    }
  //CREATE SAVINGS ENTRY
    @PostMapping("/add-savings")
    public Account createSavings(@RequestBody Savings savings) {
   	 return bestBankingAppService.createSavingsAccount(savings);
	    }
    //READ ACCOUNTS
    @GetMapping("/read-all")
    public List<Account> readAccount() {
        return bestBankingAppService.getAccounts(); //uncertain
    }
    //UPDATE ACCOUNT
    @PutMapping("/update/{id}")
    public Account updateAccount(@PathVariable(value="id") String name, @RequestBody Account accountsInfo) {
   	 return bestBankingAppService.updateAccount(name, accountsInfo);
    }
    //DELETE ACCOUNT
    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable(value="id") String name) {
    	bestBankingAppService.deleteAccounts(name);	
    }
    //PATCH ACCOUNT NAME
    @PatchMapping("/update-name/{id}/{name}")
    public Account patchAccountName(@PathVariable(value = "name") String name) {
    	return bestBankingAppService.updateAccountName(name, name);
    }
    /*
  //PATCH CONTACT NAME
   @PatchMapping("/update-number/{id}/{number}")
   Account patchAccountNumber(@PathVariable(value = "id") Long id, @PathVariable(value = "number") Account number) {
    }
    */
}

