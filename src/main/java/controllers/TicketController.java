package controllers;

import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import models.Gate;
import models.ParkingLot;
import models.enums.ResponseStatus;
import services.TicketService;

public class TicketController {

    private final TicketService ticketService;
    private final ParkingLot parkingLot;

    public TicketController(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.ticketService = new TicketService();
    }

    public TicketController(ParkingLot parkingLot, TicketService ticketService) {
        this.parkingLot = parkingLot;
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO request) {
        Gate entryGate = parkingLot.getGates().stream()
                .filter(g -> g.getId() == request.getGateId())
                .findFirst()
                .orElse(null);

        if (entryGate == null) {
            return new IssueTicketResponseDTO(null, ResponseStatus.FAILURE,
                    "Gate with id " + request.getGateId() + " not found.");
        }

        return ticketService.issueTicket(request, parkingLot, entryGate);
    }
}
