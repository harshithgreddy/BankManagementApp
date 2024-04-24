package com.bankmanagement.app.service;

import com.bankmanagement.app.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public Account createAccount(Account account);
    public Optional<Account> getAccountDetailsByAccountNumber(Long account_number);
    public List<Account> getAllAccountDetails();
    public Account depositMoney(Long account_number,Double amount);
    public Account withdrawAmount (Long account_number, Double amount);
    public void deleteAccount(Long account_number);
}
