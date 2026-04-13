package models;

import models.enums.VehicleType;

public class SupportedVehicleType extends BaseModel {
    private VehicleType vehicleType;
    private double pricePerHour;

    public SupportedVehicleType() {}

    public SupportedVehicleType(VehicleType vehicleType, double pricePerHour) {
        this.vehicleType = vehicleType;
        this.pricePerHour = pricePerHour;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "SupportedVehicleType{vehicleType=" + vehicleType + ", pricePerHour=" + pricePerHour + "}";
    }
}
