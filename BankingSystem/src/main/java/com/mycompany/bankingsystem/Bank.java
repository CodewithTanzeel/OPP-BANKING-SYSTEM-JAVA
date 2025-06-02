/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;
import com.opencsv.CSVReader;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bank extends BankAccount{
    private List<Customer> customers = new ArrayList<>();
    private List<BankAccount> accounts = new ArrayList<>();

    public Bank(String firstName, String lastName, String age, String gender, String mobileNumber, String accNumber,double balance) {
        super(firstName, lastName, age, gender, mobileNumber, accNumber,balance);
    }

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

