package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {


    private final float[] debit;
    private final float[] credits;


    public SavingsCalculator(float[] debit, float[] credits) {
        this.debit = debit;
        this.credits = credits;
    }

    private float sumOFCredits() {

        float sum = 0.f;

        for (int i = 0; i < this.credits.length; i++) {

            sum += this.credits[i];
        }

        return sum;
    }

    private float sumOFDebits() {

        float sum = 0.f;

        for (int i = 0; i < this.debit.length; i++) {

            sum += this.debit[i];
        }

//        for (Float x: credits
//             ) {
//            System.out.println(x);
//        }

        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {

        YearMonth yearMonth =  YearMonth.of(date.getYear(),date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays =  date.getDayOfMonth() - totalDaysInMonth;
        return remainingDays;
    }

    public float calculate() {
        return sumOFDebits() - sumOFCredits();
    }


    public static void main(String[] args) {
        final String[] creditsAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");

        final float[] credits = new float[creditsAsString.length];
        final float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for (int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        final SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }
}

