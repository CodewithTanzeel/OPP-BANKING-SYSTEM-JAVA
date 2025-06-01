/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankingsystem;

/**
 *
 * @author LENOVO
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
public class BankingSystem {

    public static void main(String[] args) {
        Scanner Input =new Scanner(System.in );
        String ask="yes";
        while(ask.equalsIgnoreCase("yes")){
            System.out.print("Please select your choice:\n1.login \n2.register \nEnter:");
            String choice=Input.next();
            if(choice.equalsIgnoreCase("register")){
                String firstName=Input.next();
                String lastName=Input.next();
                String age=Input.next();
                String gender=Input.next();
                String mobileNumber=Input.next();
                int accNum=(int)(100000+Math.random()*10000);
                String accNumber=""+accNum;
                Customer user=new Customer(firstName,lastName,age,gender,mobileNumber,accNumber);
                
            }
        }
    }
}
