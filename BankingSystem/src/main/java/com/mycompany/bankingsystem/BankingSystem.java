/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankingsystem;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.*;

public class BankingSystem extends Bank {
    private static final String CSV_FILE_PATH = "C:\\Users\\LENOVO\\Documents\\GitHub\\OPP-BANKING-SYSTEM-JAVA\\BankingSystem\\src\\main\\java\\com\\mycompany\\bankingsystem\\BankData.CSV";

    public BankingSystem(String firstName, String lastName, String age, String gender, String mobileNumber, String accNumber, double balance) {
        super(firstName, lastName, age, gender, mobileNumber, accNumber, balance);
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String ask = "yes";
        
        while (ask.equalsIgnoreCase("yes")) {
            System.out.print("Please select your choice:\n1. Login \n2. Register \n3. Search Customer \nEnter your choice: ");
            String choice = input.next();
            
            switch (choice.toLowerCase()) {
                case "register":
                    registerCustomer(input);
                    break;
                case "login":
                    // Add your login logic here
                    break;
                case "search":
                case "3":
                    searchCustomer(input);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.print("Do you want to continue? (yes/no): ");
            ask = input.next();
        }
    }

    private static void registerCustomer(Scanner input) throws IOException {
        CSVWriter write = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));
        
        System.out.println("--- Customer Registration ---");
        System.out.print("Enter First Name: ");
        String firstName = input.next();
        System.out.print("Enter Last Name: ");
        String lastName = input.next();
        System.out.print("Enter Age: ");
        String age = input.next();
        System.out.print("Enter Gender: ");
        String gender = input.next();
        System.out.print("Enter Mobile Number: ");
        String mobileNumber = input.next();
        
        int accNum = (int)(100000 + Math.random() * 10000);
        String accNumber = "" + accNum;
        mobileNumber = "0" + mobileNumber;
        
        String[] userData = {firstName, lastName, age, gender, mobileNumber, accNumber, "0.0"}; // Initial balance 0.0
        write.writeNext(userData);
        write.close();
        
        System.out.println("Registration successful!");
        System.out.println("Your account number is: " + accNumber);
    }

    private static void searchCustomer(Scanner input) {
        System.out.println("--- Customer Search ---");
        System.out.print("Enter search term (name, account number): ");
        String searchTerm01 = input.next();
        String searchTerm02 = input.next();
        
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE_PATH))) {
            List<String[]> allCustomers = reader.readAll();
            boolean found = false;
            
            System.out.println("\nSearch Results:");
            System.out.println("------------------------------------------------------------------");
            System.out.printf("%-15s %-15s %-5s %-8s %-15s %-10s %-10s%n", 
                "First Name", "Last Name", "Age", "Gender", "Mobile", "Account No", "Balance");
            System.out.println("------------------------------------------------------------------");
            
            for (String[] customer : allCustomers) {
                 
                    if (customer[0].equalsIgnoreCase(searchTerm01 ) && customer[5].equalsIgnoreCase(searchTerm02 )) {
                        // Print the entire customer record
                        System.out.printf("%-15s %-15s %-5s %-8s %-15s %-10s %-10s%n", 
                            customer[0], customer[1], customer[2], customer[3], 
                            customer[4], customer[5], customer[6]);
                        found = true;
                        break; // Move to next customer after finding a match
                }
            }
            
            if (!found) {
                System.out.println("No customers found matching: " + searchTerm01);
            }
            
        } catch (IOException | CsvException e) {
            System.out.println("Error reading customer data: " + e.getMessage());
        }
    }
}