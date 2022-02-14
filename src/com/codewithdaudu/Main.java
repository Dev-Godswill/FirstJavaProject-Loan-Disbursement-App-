package com.codewithdaudu;

import java.text.NumberFormat;

import java.util.Scanner;

public class Main {
//MORTGAGE CALCULATOR
    public static void main(String[] args) {
	// byte > short > int > long > float > double
        //We cannot cast a string to a number
        // implicit casting happens when we are not going to lose date
        //Define constant
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;

        System.out.println("Welcome to Baba D Loan Disbursement App");
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("What is your occupation: ");
        String occupation = scanner.next();

        while (true) {
            System.out.print("What is your monthly income after tax: ");
            int monthlyIncome = scanner.nextInt();
            if (monthlyIncome >= 1_000_000 && monthlyIncome <= 5_000_000)
                break;
            System.out.println("Dear " + name + " Sorry you are not eligible for loan");
        }

        System.out.print("Do you have any criminal record: ");
        String criminalRecord = scanner.next();

        System.out.println("Dear " + name + " kindly input loan amount");

        //User inputs Principal value (capital/loan amount he is requesting)
        System.out.print("Loan Amount: ");
        int loanAmount = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        //User states how long he needs the money for
        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments= years * MONTHS_IN_YEAR;

        double mortgage = loanAmount
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);

    }
}
