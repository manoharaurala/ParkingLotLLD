package models;

import java.util.Date;

public class Ticket extends BaseModel {
    private String ticketNumber;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Gate entryGate;
    private Date entryTime;

    public Ticket() {}

    public Ticket(String ticketNumber, Vehicle vehicle, ParkingSlot parkingSlot, Gate entryGate, Date entryTime) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryGate = entryGate;
        this.entryTime = entryTime;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "Ticket{ticketNumber='" + ticketNumber + "', vehicle=" + vehicle
                + ", parkingSlot=" + parkingSlot + ", entryTime=" + entryTime + "}";
    }
}
