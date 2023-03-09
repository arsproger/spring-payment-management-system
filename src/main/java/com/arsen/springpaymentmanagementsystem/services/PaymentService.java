package com.arsen.springpaymentmanagementsystem.services;

import com.arsen.springpaymentmanagementsystem.enums.Currency;
import com.arsen.springpaymentmanagementsystem.enums.States;
import com.arsen.springpaymentmanagementsystem.models.Payment;
import com.arsen.springpaymentmanagementsystem.models.Receive;
import com.arsen.springpaymentmanagementsystem.repositories.PaymentRepository;
import com.arsen.springpaymentmanagementsystem.repositories.ReceiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ReceiveRepository receiveRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, ReceiveRepository receiveRepository) {
        this.paymentRepository = paymentRepository;
        this.receiveRepository = receiveRepository;
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Long save(Long id, Payment payment) {
        Receive receive = receiveRepository.findById(id).orElse(null);
        if (receive == null)
            return 0L;

        payment.setReceive(receive);
        return paymentRepository.save(payment).getId();
    }

    public Long deleteById(Long id) {
        paymentRepository.deleteById(id);
        return id;
    }

    public Long updateById(Long id, Payment updatedPayment) {
        Payment payment = paymentRepository.findById(id).orElse(null);

        if (payment == null)
            return 0L;

        payment.setCurrency(updatedPayment.getCurrency());
        payment.setAmount(updatedPayment.getAmount());
        payment.setAmount(updatedPayment.getAmount());

        return paymentRepository.save(payment).getId();
    }

    public Double getPaymentSum(String name) {
        return paymentRepository.getPaymentSum(name);
    }

    public List<Payment> findByName(String name) {
        return paymentRepository.findByName(name);
    }

    public List<Payment> findByState(States states) {
        return paymentRepository.findByState(states);
    }

    public List<Payment> findByCurrency(Currency currency) {
        return paymentRepository.findByCurrency(currency);
    }
}
