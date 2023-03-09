package com.arsen.springpaymentmanagementsystem.controllers;

import com.arsen.springpaymentmanagementsystem.dto.PaymentAdminDTO;
import com.arsen.springpaymentmanagementsystem.mapper.PaymentMapper;
import com.arsen.springpaymentmanagementsystem.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @Autowired
    public AdminController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @GetMapping("/all")
    public List<PaymentAdminDTO> findAll() {
        return paymentService.findAll().stream().map(
                paymentMapper::convertToAdminDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PaymentAdminDTO findById(@PathVariable Long id) {
        return paymentMapper.convertToAdminDTO(paymentService.findById(id));
    }

    @GetMapping("/amount")
    public Integer amount() {
        return paymentService.findAll().size();
    }

}
