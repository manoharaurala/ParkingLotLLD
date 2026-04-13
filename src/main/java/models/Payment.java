package models;

import models.enums.PaymentMode;
import models.enums.PaymentStatus;

public class Payment extends BaseModel {
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private double amount;
    private String referenceId;

    public Payment() {}

    public Payment(PaymentMode paymentMode, double amount, String referenceId) {
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.referenceId = referenceId;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @Override
    public String toString() {
        return "Payment{paymentMode=" + paymentMode + ", paymentStatus=" + paymentStatus
                + ", amount=" + amount + ", referenceId='" + referenceId + "'}";
    }
}
