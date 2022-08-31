package com.example.myblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myblog.models.Account;
import com.example.myblog.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository repository;

	public boolean validateAccount(String username, String password) {
		Account account = repository.findByUsername(username);
		if (account == null || !account.getPassword().equals(password)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean createAccount(String username, String password) {
		if (repository.findByUsername(username) == null) {
			repository.save(new Account(username, password));
			return true;
		} else {
			return false;
		}
	}
}
