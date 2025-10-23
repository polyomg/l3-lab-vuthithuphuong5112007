package com.poly.lab8.service;


import com.poly.lab8.dao.AccountDao;
import com.poly.lab8.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDAO;

    @Override
    public Account findById(String username) {
        return accountDAO.findByUsername(username);
    }
}