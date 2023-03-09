package com.arsen.springpaymentmanagementsystem.services;

import com.arsen.springpaymentmanagementsystem.models.Payment;
import com.arsen.springpaymentmanagementsystem.models.Receive;
import com.arsen.springpaymentmanagementsystem.repositories.PaymentRepository;
import com.arsen.springpaymentmanagementsystem.repositories.ReceiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ReceiveService {
    private final ReceiveRepository receiveRepository;
    private final PaymentRepository paymentRepository;
    private static final String CHARACTERS =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final Random random;

    @Autowired
    public ReceiveService(ReceiveRepository receiveRepository, PaymentRepository paymentRepository, Random random) {
        this.receiveRepository = receiveRepository;
        this.paymentRepository = paymentRepository;
        this.random = random;
    }

    public List<Payment> findPayments(String name, String code) {
        return paymentRepository.findByReceiveId(
                receiveRepository.findPayments(name, code));
    }

    public Receive save(Receive receive) {
        receive.setCode(makePayment());
        return receiveRepository.save(receive);
    }

    public Long deleteById(Long id) {
        receiveRepository.deleteById(id);
        return id;
    }

    public String makePayment() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 12; i++)
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

        return password.toString();
    }

}
