package com.prakhar.demo.DependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

//    @Autowired
    PaymentService paymentService;

//    @Autowired
    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

//    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.payment();
        System.out.println("Order placed");
    }
}
