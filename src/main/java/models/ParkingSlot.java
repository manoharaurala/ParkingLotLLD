package models;

import models.enums.ParkingSlotStatus;
import models.enums.VehicleType;

public class ParkingSlot extends BaseModel {
    private int slotNumber;
    private ParkingSlotStatus status;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSlot() {}

    public ParkingSlot(int slotNumber, VehicleType vehicleType) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
        this.status = ParkingSlotStatus.AVAILABLE;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "ParkingSlot{slotNumber=" + slotNumber + ", status=" + status + ", vehicleType=" + vehicleType + "}";
    }
}
