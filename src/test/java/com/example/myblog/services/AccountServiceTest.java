package com.example.myblog.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.myblog.models.Account;
import com.example.myblog.repositories.AccountRepository;

@SpringBootTest
public class AccountServiceTest {
	@MockBean
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountService accountService;
	
	@BeforeEach
	public void prepareData() {
		Account account=new Account("Bob","123");
		when(accountRepository.save(account)).thenReturn(account);
		Account account2=new Account("Alice","BBC12");
		when(accountRepository.findByUsername("Alice")).thenReturn(account2);
	}
	
	@Test
	public void testValidateAccount_CorrectInfo_ReturnTrue() {
		assertTrue(accountService.validateAccount("Alice", "BBC12"));
	}
	
	@Test
	public void testValidateAccount_WrongUsername_ReturnFalse() {
		assertFalse(accountService.validateAccount("Bob", "Bob54321"));
	}
	
	@Test
	public void testValidateAccount_WrongPassword_ReturnFalse() {
		assertFalse(accountService.validateAccount("Alice", "BBC12321"));
	}
	
	@Test
	public void testCreateAccount_NewUsername_ReturnTrue() {
		assertTrue(accountService.createAccount("Bob", "Bob54321"));
	}
	
	@Test
	public void testCreateAccount_ExistingUsername_ReturnFalse() {
		assertFalse(accountService.createAccount("Alice", "BBC12321"));
	}
}
