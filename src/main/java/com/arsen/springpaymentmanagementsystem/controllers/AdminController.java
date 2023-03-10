package com.arsen.springpaymentmanagementsystem.controllers;

import com.arsen.springpaymentmanagementsystem.dto.PaymentDTO;
import com.arsen.springpaymentmanagementsystem.dto.ReturnReceiveDTO;
import com.arsen.springpaymentmanagementsystem.mapper.PaymentMapper;
import com.arsen.springpaymentmanagementsystem.mapper.ReceiveMapper;
import com.arsen.springpaymentmanagementsystem.services.PaymentService;
import com.arsen.springpaymentmanagementsystem.services.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final PaymentService paymentService;
    private final ReceiveService receiveService;
    private final PaymentMapper paymentMapper;
    private final ReceiveMapper receiveMapper;

    @Autowired
    public AdminController(PaymentService paymentService, ReceiveService receiveService,
                           PaymentMapper paymentMapper, ReceiveMapper receiveMapper) {
        this.paymentService = paymentService;
        this.receiveService = receiveService;
        this.paymentMapper = paymentMapper;
        this.receiveMapper = receiveMapper;
    }

    @GetMapping("/payment/all")
    public List<PaymentDTO> findAllPayment() {
        return paymentService.findAll().stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/payment/{id}")
    public PaymentDTO findByPaymentId(@PathVariable Long id) {
        return paymentMapper.convertToDTO(paymentService.findById(id));
    }

    @GetMapping("/receive/all")
    public List<ReturnReceiveDTO> findAllReceive() {
        return receiveService.findAll().stream().map(
                receiveMapper::convertToReturnDTO).collect(Collectors.toList());
    }

    @GetMapping("/receive/{id}")
    public ReturnReceiveDTO findByReceiveId(@PathVariable Long id) {
        return receiveMapper.convertToReturnDTO(receiveService.findById(id));
    }

    @GetMapping("/amount")
    public Integer amount() {
        return paymentService.findAll().size();
    }

    @DeleteMapping("/payment/{id}")
    public Long deletePaymentById(@PathVariable Long id) {
        return paymentService.deleteById(id);
    }

    @DeleteMapping("receive/{id}")
    public Long deleteReceiveById(@PathVariable Long id) {
        return receiveService.deleteById(id);
    }

    @GetMapping("/make")
    public String makePayment() {
        return receiveService.makePayment();
    }

}
