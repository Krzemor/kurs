package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.library.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatisticsTestSuite {
    private Statistics statisticsMock;
    private CalculateStatistics calculateStatistics;

    private List<String> generateListOfNUsers(int i) {
        List<String> resultList = new ArrayList<>();
        for (int n = 1; n <= i; n++) {
            resultList.add("User " + n);
        }
        return resultList;
    }

    @BeforeEach
    public void setUp() {
        statisticsMock = mock(Statistics.class);
        calculateStatistics = new CalculateStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWhenZeroPosts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(Arrays.asList("User1", "User2"));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        assertEquals(0, calculateStatistics.getPostsCount());
        assertEquals(0, calculateStatistics.getAveragePostsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWhenThousandPosts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(2));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        assertEquals(1000, calculateStatistics.getPostsCount());
        assertEquals(500, calculateStatistics.getAveragePostsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWhenZeroComments() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(2));
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        assertEquals(0, calculateStatistics.getCommentsCount());
        assertEquals(0, calculateStatistics.getAverageCommentsPerPost());
        assertEquals(0, calculateStatistics.getAverageCommentsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsLessThanPosts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(2));
        when(statisticsMock.postsCount()).thenReturn(15);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        assertEquals(15, calculateStatistics.getPostsCount());
        assertEquals(10, calculateStatistics.getCommentsCount());
        assertTrue(calculateStatistics.getAverageCommentsPerPost() < 1);
    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsGreaterThanPosts() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(2));
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(15);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateStatistics.getPostsCount());
        assertEquals(15, calculateStatistics.getCommentsCount());
        assertTrue(calculateStatistics.getAverageCommentsPerPost() > 1);
    }

    @Test
    void testCalculateAdvStatisticsWhenZeroUsers() {
        //Given
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(10);

        //When
        calculateStatistics.calculateAvgStatistics(statisticsMock);

        //Then
        assertEquals(0, calculateStatistics.getUsersCount());
        assertEquals(0, calculateStatistics.getAveragePostsPerUser());
        assertEquals(0, calculateStatistics.getAverageCommentsPerUser());
    }

    @Test
    void testCalculateAdvStatisticsWhenHundredUsers() {
        when(statisticsMock.usersNames()).thenReturn(generateListOfNUsers(100));
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(200);

        calculateStatistics.calculateAvgStatistics(statisticsMock);

        assertEquals(100, calculateStatistics.getUsersCount());
        assertEquals(1, calculateStatistics.getAveragePostsPerUser());
        assertEquals(2, calculateStatistics.getAverageCommentsPerUser());

    }
}
