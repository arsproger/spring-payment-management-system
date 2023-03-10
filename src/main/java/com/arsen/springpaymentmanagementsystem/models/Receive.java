package com.arsen.springpaymentmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String code;
    private String role;
    @OneToMany(mappedBy = "receive")
    private List<Payment> paymentList;
}
