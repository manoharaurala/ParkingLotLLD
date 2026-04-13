package dtos;

import models.Ticket;
import models.enums.ResponseStatus;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String message;

    public IssueTicketResponseDTO() {}

    public IssueTicketResponseDTO(Ticket ticket, ResponseStatus responseStatus, String message) {
        this.ticket = ticket;
        this.responseStatus = responseStatus;
        this.message = message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "IssueTicketResponseDTO{responseStatus=" + responseStatus
                + ", message='" + message + "', ticket=" + ticket + "}";
    }
}
