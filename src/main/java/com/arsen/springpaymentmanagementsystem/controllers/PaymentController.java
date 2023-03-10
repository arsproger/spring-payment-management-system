package com.arsen.springpaymentmanagementsystem.controllers;

import com.arsen.springpaymentmanagementsystem.dto.PaymentDTO;
import com.arsen.springpaymentmanagementsystem.enums.Currency;
import com.arsen.springpaymentmanagementsystem.enums.States;
import com.arsen.springpaymentmanagementsystem.mapper.PaymentMapper;
import com.arsen.springpaymentmanagementsystem.models.Receive;
import com.arsen.springpaymentmanagementsystem.security.ReceiveDetails;
import com.arsen.springpaymentmanagementsystem.services.PaymentService;
import com.arsen.springpaymentmanagementsystem.services.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final ReceiveService receiveService;
    private final PaymentMapper paymentMapper;

    private Receive getReceive() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ReceiveDetails receiveDetails = (ReceiveDetails) authentication.getPrincipal();
        return receiveDetails.getReceive();
    }

    @Autowired
    public PaymentController(PaymentService paymentService, ReceiveService receiveService,
                             PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.receiveService = receiveService;
        this.paymentMapper = paymentMapper;
    }

    @GetMapping
    public String main() {
        return "Hello World!";
    }

    @GetMapping("/all")
    public List<PaymentDTO> findAll() {
        return receiveService.findPayments(getReceive().getId()).stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping
    public Long save(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.save(getReceive().getId(), paymentMapper.convertToEntity(paymentDTO));
    }

    @GetMapping("/sum/{currency}")
    public Double getPaymentSum(@PathVariable String currency) {
        return paymentService.getPaymentSum(getReceive().getId(), currency);
    }

    @GetMapping("/getName/{name}")
    public List<PaymentDTO> findByName(@PathVariable String name) {
        return paymentService.findByNameAndReceiveId(name, getReceive().getId()).stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/getState/{state}")
    public List<PaymentDTO> findByState(@PathVariable String state) {
        return paymentService.findByStateAndReceiveId(States.valueOf(state), getReceive().getId()).stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/getCurrency/{currency}")
    public List<PaymentDTO> findByCurrencyAndReceiveId(@PathVariable String currency) {
        return paymentService.findByCurrencyAndReceiveId(Currency.valueOf(currency), getReceive().getId()).
                stream().map(paymentMapper::convertToDTO).collect(Collectors.toList());
    }

}