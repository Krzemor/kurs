package com.kodilla.stream;

public class StreamMain {

    public static String mirrorString(String input) {
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        String[] testCases = {"Adam", "Ewa", "Kajak"};

        for (String testCase : testCases) {
            System.out.println(testCase + " -> " + mirrorString(testCase));
        }
    }

}

