package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    private Display display;

    @Autowired
    public Calculator(Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        double sum = a + b;
        display.displayValue(sum);
        return sum;
    }

    public double sub(double a, double b) {
        double subtraction = a - b;
        display.displayValue(subtraction);
        return subtraction;
    }

    public double mul(double a, double b) {
        double multiplication = a * b;
        display.displayValue(multiplication);
        return multiplication;
    }

    public double div(double a, double b) {
        double division = a / b;
        display.displayValue(division);
        return division;
    }

}
