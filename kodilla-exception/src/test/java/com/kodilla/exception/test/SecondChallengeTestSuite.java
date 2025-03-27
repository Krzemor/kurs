package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondChallengeTestSuite {

    @Test
    void testExceptionForXLessThanOne () {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyWillThrowException(0.9, 1.0));
    }

    @Test
    void testExceptionForXEqualOrGreaterThanTwo () {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyWillThrowException(2.0, 1.0));
    }

    @Test
    void testExceptionForYEqualToOnePointFive () {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & Then
        assertThrows(Exception.class, () -> secondChallenge.probablyWillThrowException(1.5, 1.5));
    }
}
