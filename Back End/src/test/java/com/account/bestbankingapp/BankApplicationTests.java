package com.account.bestbankingapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.account.bestbankingapp.repository.BestBankingAppRespository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BankApplicationTests {

	@Autowired
	BestBankingAppRespository bRepo;
	
	@Test
	@Order(1)
    public void testCreate () {
		Checking a = new Checking();
		a.setName("Shanes Checking Account");
		a.setSsn("077812345");
		a.setBalance(50000.0);
		a.setRate(2.5);
		a.setDebitCardPin(003);
		a.setDebitCardNumber(42524542);
		a.setAccountNum("123456");
		bRepo.save(a); //saving to database
		assertNotNull(bRepo.findById("123456").get());
	}
	//reading all records from database
		@Test
		@Order(2)
		public void testReadAll() {
			List<Account> list = bRepo.findAll();
			assertThat(list).size().isGreaterThan(0);
}
		//testing single checking accounts
		@Test
		@Order(3)
		public void testSingleAccount() {
			Checking c = (Checking) bRepo.findById("123456").get();
			assertEquals("Shanes Checking Account", c.getName());
		}
		//deleting
		//@Test
		//@Order(4)
		//public void testDelete() {
			//bRepo.deleteById("Savings-10004");
			//assertThat(bRepo.existsById("Savings-10004")).isFalse();
			//assertThat(mRepo.existsById(2L)).isTrue();

		//}
	}

		
