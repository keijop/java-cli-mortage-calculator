package com.mortageCalculator;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        String principal = scanner.next();

        System.out.print("Annual interest rate: ");
        String yearlyRate = scanner.next();

        System.out.print("Period (years): ");
        String period = scanner.next();

        Double months = Double.parseDouble(period) / 12;
        Double monthlyRate = Double.parseDouble(yearlyRate) / 100 / 12;
        Double payments = Double.parseDouble(period) * 12;
        Double monthlyMortgagePayment = Double.parseDouble(principal) * (monthlyRate * Math.pow((1 +  monthlyRate), payments)) / ( Math.pow((1 +  monthlyRate), payments)  - 1);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        System.out.print("Mortgage: " + formatter.format(monthlyMortgagePayment));

    }
}
