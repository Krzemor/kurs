package com.kodilla.stream;

import com.kodilla.stream.iterate.NumbersGenerate;

public class StreamMain {
    public static void main(String[] args) {

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerate.generateEven(20);
    }
}
