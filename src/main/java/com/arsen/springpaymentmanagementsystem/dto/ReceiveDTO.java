package com.arsen.springpaymentmanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class ReceiveDTO {
    @NotEmpty(message = "Имя не может быть пустым!")
    private String name;
    private String surname;
    @Email(message = "Некорректный email")
    @NotEmpty(message = "Email не может быть пустым")
    private String email;
}
