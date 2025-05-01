package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        // Given
        Logger logger = Logger.INSTANCE;
        String testLog = "Some test log";
        String testLog2 = "Some test log2";

        // When
        logger.log(testLog);
        logger.log(testLog2);

        // Then
        assertEquals(testLog2, logger.getLastLog());
    }
}
