package controllers;

import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import models.Ticket;
import models.enums.ResponseStatus;
import services.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO) {

        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try {
            Ticket ticket = ticketService.issueticket(requestDTO.getGateId(),
                    requestDTO.getVehicleNumber(),
                    requestDTO.getOwnerName(),
                    requestDTO.getVehicleType());
            responseDTO.setTicket(ticket);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setFailureMessage(e.getMessage());
        }
        return responseDTO;
    }
}
