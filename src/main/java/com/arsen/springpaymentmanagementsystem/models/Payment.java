package com.arsen.springpaymentmanagementsystem.models;

import com.arsen.springpaymentmanagementsystem.enums.Currency;
import com.arsen.springpaymentmanagementsystem.enums.States;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 0, message = "Количество не может быть отрицательным!")
    private Double amount;
    @NotEmpty(message = "Имя не может быть пустым!")
    private String name;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private States state;
    @ManyToOne
    @JoinColumn(name = "receive", referencedColumnName = "id")
    private Receive receive;
}
