package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge chall = new SecondChallenge();

        try {
            String result = chall.probablyWillThrowException(1.5, 1);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            System.out.println("Finished");
        }
    }

}
