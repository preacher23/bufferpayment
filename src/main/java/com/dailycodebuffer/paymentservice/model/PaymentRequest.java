package com.dailycodebuffer.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String referncenumber;
    private long orderid;
    private long amount;
    private Paymentmode paymentmode;
}
