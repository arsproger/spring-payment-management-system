package com.arsen.springpaymentmanagementsystem.dto;

import com.arsen.springpaymentmanagementsystem.enums.Currency;
import com.arsen.springpaymentmanagementsystem.enums.States;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class PaymentDTO {
    @Min(value = 0, message = "Количество не может быть отрицательным!")
    private Double amount;
    @NotEmpty(message = "Имя не может быть пустым!")
    private String name;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private States state;
}
