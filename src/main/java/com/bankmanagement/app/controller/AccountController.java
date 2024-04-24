package com.bankmanagement.app.controller;

import com.bankmanagement.app.entity.Account;
import com.bankmanagement.app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    //create the account
    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account){
        Account created_account = accountService.createAccount(account);
        return created_account;
    }

    @GetMapping("/{account_number}")
    public Optional<Account> getAccount(@PathVariable Long account_number){
        Optional<Account> get_account = accountService.getAccountDetailsByAccountNumber(account_number);
        return get_account;
    }

    @GetMapping("/allaccounts")
    public List<Account> getAllAccounts(){
        List<Account> allAccounts = accountService.getAllAccountDetails();
        return allAccounts;
    }

    @PutMapping("/deposit/{account_number}/{amount}")
    public Account depositMoney(@PathVariable Long account_number,@PathVariable Double amount){
        Account account = accountService.depositMoney(account_number,amount);
        return account;
    }

    @PutMapping("/withdraw/{account_number}/{amount}")
    public Account withdrawMoney(@PathVariable Long account_number,@PathVariable Double amount){
        Account account = accountService.withdrawAmount(account_number,amount);
        return account;
    }

    @DeleteMapping("/delete/{account_number}")
    public ResponseEntity deleteAccount(@PathVariable Long account_number){
        accountService.deleteAccount(account_number);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
