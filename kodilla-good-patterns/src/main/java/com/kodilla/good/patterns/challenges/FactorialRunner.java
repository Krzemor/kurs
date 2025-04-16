package com.kodilla.good.patterns.challenges;

public class FactorialRunner {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        long result = factorial.factorial(5);

        System.out.println(result);
    }
}
