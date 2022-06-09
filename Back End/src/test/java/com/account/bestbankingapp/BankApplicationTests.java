package com.account.bestbankingapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.account.bestbankingapp.model.Account;
import com.account.bestbankingapp.model.Checking;
import com.account.bestbankingapp.model.Savings;
import com.account.bestbankingapp.repository.BestBankingAppRespository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BankApplicationTests {

	@Autowired
	BestBankingAppRespository bRepo;
	
	@Test
	@Order(1)
    public void testCreateChecking () {
		Checking a = new Checking();
		a.setName("Shanes Checking Account");
		a.setSsn("077812345");
		a.setBalance(50000.0);
		a.setRate(2.5);
		a.setDebitCardPin(003);
		a.setDebitCardNumber(42524542);
		a.setAccountNum("Shanes Checking Account");
		bRepo.save(a); //saving to database
		assertNotNull(bRepo.findById("Shanes Checking Account").get());
	}
	@Test
	@Order(2)
	 public void testCreateSavings () {
	Savings s = new Savings();
	s.setName("Shanes Savings Account");
	s.setSsn("077812345");
	s.setBalance(50000.0);
	s.setRate(2.5);
	s.setAccountNum("Shanes Savings Account");
	s.setSafetyDepositBoxID(11);
	s.setSafetyDepositBoxKey(77);
	bRepo.save(s); //saving to database
	assertNotNull(bRepo.findById("Shanes Savings Account").get());
}
	//reading all records from database
		@Test
		@Order(3)
		public void testReadAll() {
			List<Account> list = bRepo.findAll();
			assertThat(list).size().isGreaterThan(0);
}
		//testing single checking accounts
		@Test
		@Order(4)
		public void testSingleAccount() {
			Checking c = (Checking) bRepo.findById("Shanes Checking Account").get();
			assertEquals("Shanes Checking Account", c.getName());
		}
		//updating 
		@Test
		@Order(5)
		public void testUpdate() {
			Savings c = (Savings) bRepo.findById("Shanes Savings Account").get();
			c.setAccountNum("Elon Musk Checking");
			c.setBalance(1000000000);
			bRepo.save(c);
			assertNotEquals(222, bRepo.findById("Shanes Savings Account").get().getAccountNum());
		}
		//deleting
		@Test
		@Order(6)
		public void testDelete() {
			bRepo.deleteById("Shanes Savings Account");
			assertThat(bRepo.existsById("Shanes Savings Account")).isFalse();
			bRepo.deleteById("Shanes Checking Account");
			assertThat(bRepo.existsById("Shanes Checking")).isFalse();
			//assertThat(bRepo.existsById(2L)).isTrue();
	}
		
}

		
