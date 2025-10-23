package com.poly.lab8.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.lab8.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, String> {
    Account findByUsername(String username);
}
