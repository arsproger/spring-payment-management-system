package com.arsen.springpaymentmanagementsystem.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ReturnReceiveDTO {
    private Long id;
    @NotEmpty(message = "Имя не может быть пустым!")
    private String name;
    private String surname;
    @Email(message = "Некорректный email")
    @NotEmpty(message = "Email не может быть пустым")
    private String email;
    @NotEmpty(message = "Code не может быть пустым")
    @Size(min = 8, max = 12, message = "Неверный диапазон кода верификации!")
    private String code;
}
