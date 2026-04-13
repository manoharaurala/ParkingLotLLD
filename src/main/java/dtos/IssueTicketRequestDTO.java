package dtos;

import models.enums.VehicleType;

public class IssueTicketRequestDTO {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private int gateId;
    private int operatorId;

    public IssueTicketRequestDTO() {}

    public IssueTicketRequestDTO(String vehicleNumber, VehicleType vehicleType, int gateId, int operatorId) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.gateId = gateId;
        this.operatorId = operatorId;
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

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }
}
