package com.kodilla.good.patterns.challenges;

public class OrderMain {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();

        ProductOrderService productOrderService = new ProductOrderService(
                new EmailInformationService(),
                new OneOrderService(),
                new OrderRepoInMemory());

        OrderDto order = productOrderService.process(orderRequestRetriever.retrieve());
        System.out.println("Is order successful? " + order.isOrdered());
    }
}
