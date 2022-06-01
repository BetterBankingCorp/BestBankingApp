package com.account.bestbankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.bestbankingapp.model.Account;
import com.account.bestbankingapp.service.BestBankingAppService;

@RestController
@RequestMapping("/Best_BankingApp")
public class BestBankingAppController {
	@Autowired
    BestBankingAppService bestBankingAppService;

	//CREATE CHECKING ENTRY
    @PostMapping("/add-checking")
    public Account createChecking(@RequestBody Checking checking) {
   	 return bestBankingAppService.createChecking(checking);
    }
  //CREATE SAVINGS ENTRY
    @PostMapping("/add-savings")
    public Account createSavings(@RequestBody Savings savings) {
   	 return bestBankingAppService.createSavings(savings);
	    }
    //READ ACCOUNTS
    @GetMapping("/read-all")
    public List<Account> readAccount() {
        return bestBankingAppService.getAccounts(); //uncertain
    }
    //UPDATE ACCOUNT
    @PutMapping("/update/{id}")
    public Account updateAccount(@PathVariable(value="id") Long id, @RequestBody Account personsInfo) {
   	 return bestBankingAppService.updateAccount(id, personsInfo);
    }
    //DELETE ACCOUNT
    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable(value="id") Long id) {
    	bestBankingAppService.deleteAccount(id);	
    }
    //PATCH ACCOUNT NAME
    @PatchMapping("/update-name/{id}/{name}")
    public Account patchAccountName(@PathVariable(value = "id") Long id, @PathVariable(value = "name") String name) {
    	return bestBankingAppService.updateAccountName(id, name);
    }
    //PATCH CONTACT NAME
    @PatchMapping("/update-number/{id}/{number}")
    public Account patchAccountNumber(@PathVariable(value = "id") Long id, @PathVariable(value = "number") String number) {
    	return bestBankingAppService.updateAccountNumber(id, number);
    }
}

