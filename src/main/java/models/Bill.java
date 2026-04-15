package models;

import java.time.LocalDateTime;
import java.util.List;

public class Bill extends BaseModel {
    private LocalDateTime exitTime;
    private double amount;
    private Gate gate;
    private Operator operator;
    private Ticket ticket;
    private List<Payment> payments;

}
