package services;

import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import models.Gate;
import models.ParkingLot;
import models.ParkingSlot;
import models.Ticket;
import models.Vehicle;
import models.enums.ParkingLotStatus;
import models.enums.ParkingSlotStatus;
import models.enums.ResponseStatus;
import strategies.DefaultParkingSpotAssignmentStrategy;
import strategies.ParkingSpotAssignmentStrategy;

import java.util.Date;
import java.util.UUID;

public class TicketService {

    private final ParkingSpotAssignmentStrategy strategy;

    public TicketService() {
        this.strategy = new DefaultParkingSpotAssignmentStrategy();
    }

    public TicketService(ParkingSpotAssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request, ParkingLot parkingLot, Gate entryGate) {
        if (parkingLot.getStatus() != ParkingLotStatus.OPEN) {
            return new IssueTicketResponseDTO(null, ResponseStatus.FAILURE, "Parking lot is not open.");
        }

        if (entryGate == null) {
            return new IssueTicketResponseDTO(null, ResponseStatus.FAILURE, "Entry gate not found.");
        }

        ParkingSlot slot = strategy.assignSlot(parkingLot.getParkingFloors(), request.getVehicleType());
        if (slot == null) {
            return new IssueTicketResponseDTO(null, ResponseStatus.FAILURE,
                    "No available slot for vehicle type: " + request.getVehicleType());
        }

        Vehicle vehicle = new Vehicle(request.getVehicleNumber(), request.getVehicleType());

        slot.setStatus(ParkingSlotStatus.OCCUPIED);
        slot.setVehicle(vehicle);

        String ticketNumber = "TKT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Ticket ticket = new Ticket(ticketNumber, vehicle, slot, entryGate, new Date());

        return new IssueTicketResponseDTO(ticket, ResponseStatus.SUCCESS, "Ticket issued successfully.");
    }
}
