package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Jakub");

        return new OrderRequest(user, "Computer");
    }
}
