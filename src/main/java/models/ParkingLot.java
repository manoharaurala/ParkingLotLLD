package models;

import models.enums.ParkingLotStatus;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    private ParkingLotStatus status;
    private List<Gate> gates;
    private List<ParkingFloor> parkingFloors;
    private List<SupportedVehicleType> supportedVehicleTypes;

    public ParkingLot() {}

    public ParkingLot(String name, String address, List<Gate> gates,
                      List<ParkingFloor> parkingFloors, List<SupportedVehicleType> supportedVehicleTypes) {
        this.name = name;
        this.address = address;
        this.status = ParkingLotStatus.OPEN;
        this.gates = gates;
        this.parkingFloors = parkingFloors;
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<SupportedVehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<SupportedVehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    @Override
    public String toString() {
        return "ParkingLot{name='" + name + "', address='" + address + "', status=" + status + "}";
    }
}
