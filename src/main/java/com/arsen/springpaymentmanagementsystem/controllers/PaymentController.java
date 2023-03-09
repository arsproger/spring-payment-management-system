package com.arsen.springpaymentmanagementsystem.controllers;

import com.arsen.springpaymentmanagementsystem.dto.PaymentDTO;
import com.arsen.springpaymentmanagementsystem.enums.Currency;
import com.arsen.springpaymentmanagementsystem.enums.States;
import com.arsen.springpaymentmanagementsystem.mapper.PaymentMapper;
import com.arsen.springpaymentmanagementsystem.models.Payment;
import com.arsen.springpaymentmanagementsystem.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentController(PaymentService paymentService, PaymentMapper paymentMapper) {
        this.paymentService = paymentService;
        this.paymentMapper = paymentMapper;
    }

    @GetMapping
    public String main() {
        return "Hello World!";
    }

    @GetMapping("/all")
    public List<PaymentDTO> findAll() {
        return paymentService.findAll().stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable Long id) {
        return paymentMapper.convertToDTO(paymentService.findById(id));
    }

    @PostMapping("/{id}")
    public Long save(@PathVariable Long id, @RequestBody PaymentDTO paymentDTO) {
        return paymentService.save(id, paymentMapper.convertToEntity(paymentDTO));
    }

    @DeleteMapping("/{id}")
    public Long deleteById(@PathVariable Long id) {
        return paymentService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Long updateById(@PathVariable Long id, @RequestBody Payment payment) {
        return paymentService.updateById(id, payment);
    }

    @GetMapping("/sum/{currency}")
    public Double getPaymentSum(@PathVariable String currency) {
        return paymentService.getPaymentSum(currency);
    }

    @GetMapping("/getName/{name}")
    public List<PaymentDTO> findByName(@PathVariable String name) {
        return paymentService.findByName(name).stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/getState/{state}")
    public List<PaymentDTO> findByState(@PathVariable String state) {
        return paymentService.findByState(States.valueOf(state)).stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("/getCurrency/{currency}")
    public List<PaymentDTO> findByCurrency(@PathVariable String currency) {
        return paymentService.findByCurrency(Currency.valueOf(currency)).stream().map(
                paymentMapper::convertToDTO).collect(Collectors.toList());
    }

}