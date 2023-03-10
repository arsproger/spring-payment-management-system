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

    public Double getPaymentSum(Long id, String name) {
        return paymentRepository.getPaymentSum(id, name);
    }

    public List<Payment> findByNameAndReceiveId(String name, Long id) {
        return paymentRepository.findByNameAndReceiveId(name, id);
    }

    public List<Payment> findByStateAndReceiveId(States states, Long id) {
        return paymentRepository.findByStateAndReceiveId(states, id);
    }

    public List<Payment> findByCurrencyAndReceiveId(Currency currency, Long id) {
        return paymentRepository.findByCurrencyAndReceiveId(currency, id);
    }
}
