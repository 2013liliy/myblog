package com.example.myblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.myblog.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUsername(String username);

	Account save(Account account);

}
