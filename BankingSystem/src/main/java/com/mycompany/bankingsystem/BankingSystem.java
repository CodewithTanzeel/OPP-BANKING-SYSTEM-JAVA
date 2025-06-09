/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankingsystem;

/**
 *
 * @author LENOVO
 */

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;


public class BankingSystem extends Bank{
     public BankingSystem(String firstName, String lastName, String age, String gender, String mobileNumber, String accNumber,double balance) {
        super(firstName, lastName, age, gender, mobileNumber, accNumber,balance);
    }

    public static void main(String[] args) throws IOException, CsvException{
        
        
        String path="C:\\Users\\LENOVO\\Documents\\GitHub\\OPP-BANKING-SYSTEM-JAVA\\BankingSystem\\src\\main\\java\\com\\mycompany\\bankingsystem\\BankData.CSV";
      
        Scanner Input =new Scanner(System.in );
        String ask="yes";
        while(ask.equalsIgnoreCase("yes")){
            System.out.print("Please select your choice:\n1.login \n2.register \nEnter:");
            String choice=Input.next();
            if(choice.equalsIgnoreCase("register")){
                System.out.print("Enter firstName, lastName, age, gender, mobileNumber: ");
                String firstName = Input.next();
                String lastName = Input.next();
                String age = Input.next();
                String gender = Input.next();
                String mobileNumber = Input.next();
                int accNum = (int) (100000 + Math.random() * 10000);
                String accNumber = "" + accNum;
                String[] userData = {firstName, lastName, age, gender, mobileNumber, accNumber, "0.0"};

                try (CSVWriter write = new CSVWriter(new FileWriter(path, true))) {
                    write.writeNext(userData);
                }

                System.out.println("Registration successful! Your account number is: " + accNumber);
                break;

            }
            else if (choice.equalsIgnoreCase("login")) {
                try (CSVReader reader = new CSVReader(new FileReader(path))) {
                    System.out.println("Enter your first name and account number:");
                    String confirmName = Input.next();
                    String confirmAccountNumber = Input.next();
                    List<String[]> allCustomer = reader.readAll();
                    boolean found = false;

                    for (String[] customer : allCustomer) {
                        if (confirmName.equalsIgnoreCase(customer[0]) && confirmAccountNumber.equalsIgnoreCase(customer[5])) {
                            found = true;
                            System.out.println("Login successful!");
                            double balance = Double.parseDouble(customer[6]); // index was 6, not 7
                            Bank user = new Bank(customer[0], customer[1], customer[2], customer[3], customer[4], customer[5], balance);
                            double Balance ;
                            Balance = 0;
                            double new_amount=0 ;
                            double withdrawal_amount=0 ;
        
                            Scanner in = new Scanner (System.in);
                            System.out.println("Enter (balance or with-drawal or debit or transaction) :");
                            char options = in.next().charAt(0);
                            switch (options){
                                case 'b':
                                case 'B':
                                    Balance = 90000000 ;
                                    System.out.println("Your current balance is " + Balance);
                                    break;
                                case 'w':
                                case 'W':
                                    System.out.println("Enter your amount:");
                                    withdrawal_amount = in.nextDouble();
                                    new_amount = Balance - withdrawal_amount ;
                                    System.out.println("***Your new remaining amount after with drawal is :" + new_amount );
                                    break;
                                case 'd':
                                case 'D':
                                    System.out.println("Enter your amount:");
                                    double debit_amount = in.nextDouble();
                                    new_amount = Balance + debit_amount ;
                                    System.out.println("***Your new remaining amount after debit is :" + new_amount );
                                case 't':
                                case 'T':
                                    System.out.println("Enter your amount:");
                                    double transaction_amount = in.nextDouble();
                                    System.out.println("Enter person name to which the amount is transfered:");
                                    String person_name = in.nextLine();
                                    new_amount = Balance - transaction_amount ;
                                    System.out.println("Enter person account number for transfer of money:");
                                    int acc_num = in.nextInt();
                                    System.out.println("Your transfered money amount is " + transaction_amount +
                                                        "Your new remaining amount after Transaction is :" + new_amount +
                                                        "\nTo" + person_name + 
                                                        "\nwith account number is :" + acc_num);
                
                                            }                        
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Account doesn't exist.");
                        }
                    }
                }

                
            }
        }
    }

