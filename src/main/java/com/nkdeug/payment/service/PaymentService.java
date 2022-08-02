package com.nkdeug.payment.service;

import com.nkdeug.payment.entity.Payment;
//import com.nkdeug.payment.repository.PaymentRepository;
import com.nkdeug.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }
    public String paymentProcessing() {
        // api should be 3 partyy like razorpay or stripe../paytm/amazon pay
        return new Random().nextBoolean()?"success":"failure";
    }

}
