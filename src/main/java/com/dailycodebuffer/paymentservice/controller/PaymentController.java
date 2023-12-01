package com.dailycodebuffer.paymentservice.controller;

import com.dailycodebuffer.paymentservice.model.PaymentRequest;
import com.dailycodebuffer.paymentservice.model.Paymentresponse;
import com.dailycodebuffer.paymentservice.service.Paymentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
  @Autowired
    Paymentservice paymentservice;

   @PostMapping("/pay")
    public ResponseEntity<Long> dopayment(@RequestBody PaymentRequest paymentRequest){
       return new ResponseEntity<>(paymentservice.dopayment(paymentRequest), HttpStatus.CREATED);
   }
   @GetMapping("/{orderid}")
    public ResponseEntity<Paymentresponse>getpaymentdtailsbyorderid(@PathVariable String oederid){
       return new ResponseEntity<>(paymentservice.getdetails(oederid),HttpStatus.OK);
   }
}
