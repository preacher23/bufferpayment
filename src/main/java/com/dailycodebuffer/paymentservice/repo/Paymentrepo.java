package com.dailycodebuffer.paymentservice.repo;

import com.dailycodebuffer.paymentservice.entity.Transactiondetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Paymentrepo extends JpaRepository<Transactiondetails,Long> {
    Transactiondetails findByOrderid(long orderid);
}
