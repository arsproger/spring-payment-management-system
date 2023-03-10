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
    @Query(value = "SELECT SUM(amount) FROM Payments WHERE receive = :id and currency = :name", nativeQuery = true)
    Double getPaymentSum(Long id, String name);

    List<Payment> findByNameAndReceiveId(String name, Long id);

    List<Payment> findByStateAndReceiveId(States state, Long id);

    List<Payment> findByCurrencyAndReceiveId(Currency currency, Long id);

    List<Payment> findByReceiveId(Long id);
}
