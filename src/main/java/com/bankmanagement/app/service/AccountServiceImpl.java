package com.bankmanagement.app.service;

import com.bankmanagement.app.entity.Account;
import com.bankmanagement.app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;
    Account accountentity;
    @Override
    public Account createAccount(Account account) {
        Account saved_account = accountRepository.save(account);
        return saved_account;
    }

    @Override
    public Optional<Account> getAccountDetailsByAccountNumber(Long account_number) {

        Optional<Account> get_account = accountRepository.findById(account_number);
        if(get_account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        return get_account;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> allAccounts = accountRepository.findAll();
        if(allAccounts.size()==0){
            throw new RuntimeException("No accounts found");
        }
        return allAccounts;
    }

    @Override
    public Account depositMoney(Long account_number, Double amount) {
       Optional<Account> account_exists =  accountRepository.findById(account_number);
       if(account_exists.isEmpty()){
           throw new RuntimeException("Account doesnot exist");
       }
       Account accountPresent = account_exists.get();
       Double newBalance = accountPresent.getBalance() + amount;
       accountPresent.setBalance(newBalance);
       accountRepository.save(accountPresent);
       return accountPresent;
    }

    @Override
    public Account withdrawAmount(Long account_number, Double amount) {
        Optional<Account> account_exists =  accountRepository.findById(account_number);
        if(account_exists.isEmpty()){
            throw new RuntimeException("Account doesnot exist");
        }
        Account accountPresent = account_exists.get();
        Double newBalance = accountPresent.getBalance() - amount;
        accountPresent.setBalance(newBalance);
        accountRepository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void deleteAccount(Long account_number) {
        getAccountDetailsByAccountNumber(account_number);
        accountRepository.deleteById(account_number);
    }
}
