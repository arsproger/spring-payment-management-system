package com.arsen.springpaymentmanagementsystem.controllers;

import com.arsen.springpaymentmanagementsystem.dto.ReceiveDTO;
import com.arsen.springpaymentmanagementsystem.dto.ReturnReceiveDTO;
import com.arsen.springpaymentmanagementsystem.mapper.ReceiveMapper;
import com.arsen.springpaymentmanagementsystem.services.ReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive")
public class ReceiveController {
    private final ReceiveService receiveService;
    private final ReceiveMapper receiveMapper;

    @Autowired
    public ReceiveController(ReceiveService receiveService, ReceiveMapper receiveMapper) {
        this.receiveService = receiveService;
        this.receiveMapper = receiveMapper;
    }

    @PostMapping("/save")
    public ReturnReceiveDTO save(@RequestBody ReceiveDTO receiveDTO) {
        return receiveMapper.convertToReturnDTO(receiveService.save(receiveMapper.convertToEntity(receiveDTO)));
    }

}
