package com.mortageCalculator;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;
        Scanner scanner = new Scanner(System.in);

        // to be able to use . symbol for entering decimal numbers, for ex. 3.29 would otherwise throw InputMismatchException in FI, ET etc. locales.
        scanner.useLocale(Locale.ENGLISH);

        int principal;1
        float yearlyRate;
        float period;

        while (true) {
            System.out.print("Principal (€1K - €1M): ");
            principal = scanner.nextInt();
            if(principal >=  1000 && principal <= 1000000){
                break;
            }
            System.out.println("Enter a value between 1000 - 1000000");
        }

        while(true){
            System.out.print("Annual interest rate: ");
            yearlyRate = scanner.nextFloat();
            if(yearlyRate >=  1 && yearlyRate <= 30){
                break;
            }
            System.out.println("Enter a value between 1 - 30: ");
        }

        while(true){
        System.out.print("Period (years): ");
            period = scanner.nextInt();
            if(period >=  1 && period <= 30){
                break;
            }
            System.out.println("Enter a value between 1 - 30: ");
        }

        Float months = period / MONTHS_IN_YEAR;
        Float monthlyRate = yearlyRate / PERCENTAGE / MONTHS_IN_YEAR;
        Float payments = period * MONTHS_IN_YEAR;
        Double monthlyMortgagePayment = principal * (monthlyRate * Math.pow((1 +  monthlyRate), payments)) / ( Math.pow((1 +  monthlyRate), payments)  - 1);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        System.out.print("Mortgage: " + formatter.format(monthlyMortgagePayment));

    }
}
