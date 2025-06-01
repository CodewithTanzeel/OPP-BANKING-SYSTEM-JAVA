/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingsystem;

/**
 *
 * @author K TECH
 */
class Customer {
      private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String mobileNumber;
    private String accNumber;
    Customer(String firstName,String lastName,String age,String gender,String mobileNumber,String accNumber){
        this.firstName = firstName;
        this.lastName=lastName;
        this.age=age;
        this.gender=gender;
        this.mobileNumber=mobileNumber;
        this.accNumber=accNumber;
        }
     private String name;


    public Customer(String name) {
        this.name = name;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    interface BankAccount{
        String accNumber;
        String Balance=;
    }
    
}
