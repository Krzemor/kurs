package com.kodilla.good.patterns.challenges;

public class OrderRepoInMemory implements OrderRepo {

    public void createOrder(User user, String product) {
        System.out.println("Saving order: " + product + ", for: " + user.getName());
    }
}
