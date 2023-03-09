package com.arsen.springpaymentmanagementsystem.repositories;

import com.arsen.springpaymentmanagementsystem.models.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Long> {
    @Query(value = "SELECT id FROM receive WHERE name = :name and code = :code", nativeQuery = true)
    Long findPayments(String name, String code);
}
