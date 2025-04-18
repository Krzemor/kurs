package com.kodilla.good.patterns.challenges;

public class OneOrderService implements OrderService {

    public boolean order(User user, String product) {
        System.out.println("Ordering: " + product + ", for: " + user.getName());
        return true;
    }
}
