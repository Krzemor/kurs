package com.kodilla.good.patterns.challenges;

public class OrderRequest {

    private User user;
    private String product;

    public OrderRequest(User user, String product) {
        this.user = user;
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }
}
