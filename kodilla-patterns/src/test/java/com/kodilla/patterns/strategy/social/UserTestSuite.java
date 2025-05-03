package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User andrew = new Millenials("Andrew");
        User tom = new YGeneration("Tom");
        User john = new ZGeneration("John");

        //When
        String adrewShouldShare = andrew.sharePost();
        String tomShouldShare = tom.sharePost();
        String johnShouldShare = john.sharePost();

        //Then
        assertEquals("[Facebook] some post", adrewShouldShare);
        assertEquals("[Twitter] some post", tomShouldShare);
        assertEquals("[Snapchat] some post", johnShouldShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User andrew = new Millenials("Andrew");

        //When
        andrew.setSocialPublisher(new SnapchatPublisher());

        //Then
        assertEquals("[Snapchat] some post", andrew.sharePost());
    }
}
