package com.account.bestbankingapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.account.bestbankingapp.model.Account;


@Repository
public interface BestBankingAppRespository extends JpaRepository <Account, String>{

}