package com.account.bestbankingapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.account.bestbankingapp.model.Account;


@Repository
public interface BestBankingAppRespository extends JpaRepository <Account, String>{
	@Query(value="SELECT * FROM account a WHERE a.member_id = :member_id AND a.password = :password", nativeQuery=true)
	public List<Account> findByMemberIDAndPass(@Param("member_id") String SSN, @Param("password") String password);
}