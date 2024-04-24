package com.bankmanagement.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long account_number;
    private String account_holder_name;
    private double balance;

    public Account(String account_holder_name, double balance) {
        this.account_holder_name = account_holder_name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", account_holder_name='" + account_holder_name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account() {
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
