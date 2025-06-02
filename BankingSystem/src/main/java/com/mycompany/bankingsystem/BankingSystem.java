/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankingsystem;

/**
 *
 * @author LENOVO
 */
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;
public class BankingSystem extends Bank{
     public BankingSystem(String firstName, String lastName, String age, String gender, String mobileNumber, String accNumber,double balance) {
        super(firstName, lastName, age, gender, mobileNumber, accNumber,balance);
    }

    public static void main(String[] args) throws IOException{
        
        CSVWriter write=new CSVWriter(new FileWriter("C:\\Users\\LENOVO\\Documents\\GitHub\\OPP-BANKING-SYSTEM-JAVA\\BankingSystem\\src\\main\\java\\com\\mycompany\\bankingsystem\\BankData.CSV"));
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
                System.out.print(mobileNumber);
                int accNum=(int)(100000+Math.random()*10000);
                String accNumber=""+accNum;
                Customer user=new Customer(firstName,lastName,age,gender,mobileNumber,accNumber);
                mobileNumber="0"+mobileNumber;
                String[] userData={firstName,lastName,age,gender,mobileNumber,accNumber};
                write.writeNext(userData);
                write.flush();
                break;
                
                
            }
        }
    }
}
