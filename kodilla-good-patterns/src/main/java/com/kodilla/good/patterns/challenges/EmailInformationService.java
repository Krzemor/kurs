package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements InformationService {

    public void information(User user) {
        System.out.println("Informing: " + user.getName());
    }
}
