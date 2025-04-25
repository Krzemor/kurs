package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.StaticApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootApplication
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double sum = calculator.add(8, 2);
        double subtraction = calculator.sub(8, 2);
        double division = calculator.div(8, 2);
        double multiplication = calculator.mul(8, 2);

        //Then
        assertEquals(10, sum);
        assertEquals(6, subtraction);
        assertEquals(4, division);
        assertEquals(16, multiplication);
    }
}
