package com.arsen.springpaymentmanagementsystem.dto;

import lombok.Data;

@Data
public class PaymentAdminDTO {
    private Double amount;
    private String currency;
    private String code;
    private String state;
}
