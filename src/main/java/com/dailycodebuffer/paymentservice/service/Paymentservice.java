package com.dailycodebuffer.paymentservice.service;

import com.dailycodebuffer.paymentservice.entity.Transactiondetails;
import com.dailycodebuffer.paymentservice.model.PaymentRequest;
import com.dailycodebuffer.paymentservice.model.Paymentmode;
import com.dailycodebuffer.paymentservice.model.Paymentresponse;
import com.dailycodebuffer.paymentservice.repo.Paymentrepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class Paymentservice {
    @Autowired
    Paymentrepo paymentrepo;
    public long dopayment(PaymentRequest paymentRequest) {
        log.info("recording payment");
        Transactiondetails transactiondetails= Transactiondetails.builder().amount(paymentRequest.getAmount()).paymentdate(Instant.now())
                .paymentmode(paymentRequest.getPaymentmode().name()).paymentstatus("ok").referncenumber(paymentRequest.getReferncenumber()).orderid(paymentRequest.getOrderid())
                .build();
        paymentrepo.save(transactiondetails);

        log.info("transaction save");
        return transactiondetails.getId();
    }

    public Paymentresponse getdetails(String orderid) {
        log.info("getting payment details");
        Transactiondetails transactiondetails=paymentrepo.findByOrderid(Long.valueOf(orderid));
        Paymentresponse paymentresponse= Paymentresponse.builder().paymentid(transactiondetails.getId())
                .paymentmode(Paymentmode.CASH).paymentdate(Instant.now()).amount(transactiondetails.getAmount()).build();
        return paymentresponse;
    }
}
