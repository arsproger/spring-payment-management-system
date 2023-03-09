package com.arsen.springpaymentmanagementsystem.repositories;

import com.arsen.springpaymentmanagementsystem.enums.Currency;
import com.arsen.springpaymentmanagementsystem.enums.States;
import com.arsen.springpaymentmanagementsystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value = "SELECT SUM(amount) FROM Payments WHERE currency = :name", nativeQuery = true)
    Double getPaymentSum(String name);

    List<Payment> findByName(String name);

    List<Payment> findByState(States state);

    List<Payment> findByCurrency(Currency currency);

    List<Payment> findByReceiveId(Long id);
}
