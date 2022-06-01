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

public class BestBankingAppService extends Account {

@Autowired
BestBankingAppRespository bankrepository;

//create savings account
public Account createSavingsAccount(Savings savingsAccount) {
return bankrepository.save(savingsAccount);
}
//create checking account
public Account createCheckingAccount(Checking checkingAccount) {
return bankrepository.save(checkingAccount);
}
//read accounts
public List<Account> getAccounts(){
return bankrepository.findAll();
}
//delete accounts
public void deleteAccounts(String name) {
bankrepository.deleteById(name);
}
//update account
public Account updateAccount(String name, Account newAccount) {
Account account= bankrepository.findById(name).get();
account.setAccountNum(newAccount.getAccountNum());
return bankrepository.save(account);
}
//patch account
public Account updateAccountName(String name, String newAccountName) {
Account account=bankrepository.findById(name).get();
account.setName(newAccountName);
return bankrepository.save(account);
}
}