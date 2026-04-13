package models;

import java.util.Date;

public class Bill extends BaseModel {
    private Ticket ticket;
    private double amount;
    private Date exitTime;
    private Payment payment;

    public Bill() {}

    public Bill(Ticket ticket, double amount, Date exitTime) {
        this.ticket = ticket;
        this.amount = amount;
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Bill{amount=" + amount + ", exitTime=" + exitTime + ", payment=" + payment + "}";
    }
}
