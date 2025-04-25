package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepo orderRepo;

    public ProductOrderService(InformationService informationService, OrderService orderService, OrderRepo orderRepo) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepo = orderRepo;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct());

        if(isOrdered) {
            informationService.information(orderRequest.getUser());
            orderRepo.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
