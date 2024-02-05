package com.example.sqch11ex2.controllers;

import com.example.sqch11ex2.model.Payment;
import com.example.sqch11ex2.proxy.PaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    Logger logger = Logger.getLogger(PaymentController.class.getName());

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {

        Payment response = paymentProxy.createPayment(payment);

        logger.info("Send response with ID " + response.getId());

        return response;
    }
}
