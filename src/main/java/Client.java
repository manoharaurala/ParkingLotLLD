import controllers.TicketController;
import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import models.enums.ResponseStatus;
import models.enums.VehicleType;
import repositories.GateRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

public class Client {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
        requestDTO.setGateId(1L);
        requestDTO.setVehicleNumber("KA20 HH 0420");
        requestDTO.setOwnerName("Ruby");
        requestDTO.setVehicleType(VehicleType.TWO_WHEELER);

        IssueTicketResponseDTO responseDTO = ticketController.issueTicket(requestDTO);
        if (responseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println("Ticket Generated Successfully");
            System.out.println(responseDTO.getTicket().getParkingSlot().getSlotNumber());
        } else {
            System.out.println("Ticket is not generated due to " + responseDTO.getFailureMessage());
        }
    }
}

//creation of ticket: CRUD
// Ticket:TicketController
