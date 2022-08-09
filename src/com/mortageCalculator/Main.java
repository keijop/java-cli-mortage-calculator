package com.mortageCalculator;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        String principal = scanner.next();

        System.out.print("Annual interest rate: ");
        String yearlyRate = scanner.next();

        System.out.print("Period (years): ");
        String period = scanner.next();

        Float months = Float.parseFloat(period) / MONTHS_IN_YEAR;
        Float monthlyRate = Float.parseFloat(yearlyRate) / PERCENTAGE / MONTHS_IN_YEAR;
        Float payments = Float.parseFloat(period) * MONTHS_IN_YEAR;
        Double monthlyMortgagePayment = Float.parseFloat(principal) * (monthlyRate * Math.pow((1 +  monthlyRate), payments)) / ( Math.pow((1 +  monthlyRate), payments)  - 1);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        System.out.print("Mortgage: " + formatter.format(monthlyMortgagePayment));

    }
}
