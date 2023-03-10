package com.arsen.springpaymentmanagementsystem.mapper;

import com.arsen.springpaymentmanagementsystem.dto.PaymentDTO;
import com.arsen.springpaymentmanagementsystem.models.Payment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public PaymentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PaymentDTO convertToDTO(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public Payment convertToEntity(PaymentDTO paymentDTO) {
        return modelMapper.map(paymentDTO, Payment.class);
    }

}
