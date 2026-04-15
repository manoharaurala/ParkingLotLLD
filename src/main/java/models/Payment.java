package models;

import models.enums.PaymentMode;
import models.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel {
    private Double amount;
    private LocalDateTime time;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceNumber;
}
