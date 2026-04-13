package models;

import models.enums.VehicleType;

public class Vehicle extends BaseModel {
    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle() {}

    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{vehicleNumber='" + vehicleNumber + "', vehicleType=" + vehicleType + "}";
    }
}
