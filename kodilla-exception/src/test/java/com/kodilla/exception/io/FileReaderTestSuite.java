package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";
        //When & Then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }
}
