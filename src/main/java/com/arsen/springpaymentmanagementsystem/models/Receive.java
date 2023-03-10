package com.arsen.springpaymentmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "receive")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Receive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Имя не может быть пустым!")
    private String name;
    private String surname;
    @Column(unique = true)
    @Email(message = "Некорректный email")
    @NotEmpty(message = "Email не может быть пустым")
    private String email;
    @NotEmpty(message = "Code не может быть пустым")
    @Size(min = 8, max = 12, message = "Неверный диапазон кода верификации!")
    private String code;
    private String role;
    @OneToMany(mappedBy = "receive")
    private List<Payment> paymentList;
}
