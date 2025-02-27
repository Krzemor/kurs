package com.example.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculatorApplication {

    public int adding(int a, int b) {
        return a + b;
    }

    public int subtracting(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculatorApplication.class, args);
        CalculatorApplication calculator = new CalculatorApplication();

        System.out.println(calculator.adding(10, 20));
        System.out.println(calculator.subtracting(10, 20));

    }

}
