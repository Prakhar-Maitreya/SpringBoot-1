package com.prakhar.demo.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService
{
    //field injection
    //@Autowired
    PaymentService paymentService;

    //Constructor Injection
    //@Autowired only needed when multiple constructors
//    OrderService(PaymentService paymentService)
//    {
//        this.paymentService = paymentService;
//    }

    //Setter Injection
    @Autowired
    public void setPaymentService(PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }
    public void placeOrder()
    {
        paymentService.payment();
        System.out.println("Order Placed");
    }
}
