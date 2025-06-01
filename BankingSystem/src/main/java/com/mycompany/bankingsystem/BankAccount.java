/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author K TECH
 */
class BankAccount {
    private String accNumber;
    private double balance;

    public BankAccount(String accNumber, double balance) {
        this.accNumber = accNumber;
        this.balance = balance;
    }


    public String getAccNumber() {
        return accNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
