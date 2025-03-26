package com.kodilla.exception.power;

public class PowerRunner {

    public static int power(int base, int exponent) {

        if (base == 0) {
            if (exponent == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        int result = 1;
        int ctr = exponent;

        while (ctr > 0) {
            result *= base;
            ctr--;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = power(0,5);
        int b = power(0,0);
        int c = power(8,0);
        int d = power(8,8);
        int e = power(8,1);
    }
}
