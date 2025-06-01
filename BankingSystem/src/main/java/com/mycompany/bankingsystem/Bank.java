/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers = new ArrayList<>();
    private List<BankAccount> accounts = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void transaction(BankAccount updatedAccount) {
        accounts.removeIf(acc -> acc.getAccNumber().equals(updatedAccount.getAccNumber()));
        accounts.add(updatedAccount);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}

