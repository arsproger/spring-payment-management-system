package com.arsen.springpaymentmanagementsystem.repositories;

import com.arsen.springpaymentmanagementsystem.models.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Long> {
    Optional<Receive> findByEmail(String email);
}
