package com.arsen.springpaymentmanagementsystem.controllers;

import com.arsen.springpaymentmanagementsystem.dto.PaymentDTO;
import com.arsen.springpaymentmanagementsystem.dto.ReceiveDTO;
import com.arsen.springpaymentmanagementsystem.dto.ReturnReceiveDTO;
import com.arsen.springpaymentmanagementsystem.mapper.PaymentMapper;
import com.arsen.springpaymentmanagementsystem.mapper.ReceiveMapper;
import com.arsen.springpaymentmanagementsystem.services.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receive")
public class ReceiveController {
    private final ReceiveService receiveService;
    private final PaymentMapper paymentMapper;
    private final ReceiveMapper receiveMapper;

    @Autowired
    public ReceiveController(ReceiveService receiveService, PaymentMapper paymentMapper,
                             ReceiveMapper receiveMapper) {
        this.receiveService = receiveService;
        this.paymentMapper = paymentMapper;
        this.receiveMapper = receiveMapper;
    }


    @GetMapping
    public List<PaymentDTO> findPayments(@RequestParam String name, @RequestParam String code) {
        return receiveService.findPayments(name, code)
                .stream().map(paymentMapper::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ReturnReceiveDTO save(@RequestBody ReceiveDTO receiveDTO) {
        return receiveMapper.convertToReturnDTO(receiveService.save(receiveMapper.convertToEntity(receiveDTO)));
    }

    @DeleteMapping("/{id}")
    public Long deleteById(@PathVariable Long id) {
        return receiveService.deleteById(id);
    }

    @GetMapping("/make")
    public String makePayment() {
        return receiveService.makePayment();
    }

}
