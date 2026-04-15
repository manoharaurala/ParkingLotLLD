package services;

import models.*;
import models.enums.SlotAssignmentStrategyType;
import models.enums.VehicleType;
import repositories.GateRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.factory.RandomSlotAssignmentStrategyFactory;
import strategies.factory.SlotAssignmentStrategyFactory;

import java.time.LocalDateTime;
import java.util.Optional;

public class TicketService {
    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueticket(Long gateId, String vehicleNumber, String ownerName,
                              VehicleType vehicleType) throws Exception {


        //To create ticket object
        /*
        1.propertly create object
        2.Assign slot
        3.Return ticket
         */
        //1.propertly create object
        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        Optional<Gate> gateOptional = gateRepository.findById(gateId);
        if (gateOptional.isEmpty()) {
            throw new Exception("Gate not found ");
        }

        Gate gate = gateOptional.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if (optionalVehicle.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setLicencePlate(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        } else {
            vehicle = optionalVehicle.get();
        }

        ticket.setVehicle(vehicle);

        //2. Assign Slot
        ParkingLot parkingLot = gate.getParkingLot();
        SlotAssignmentStrategyFactory factory = null;

        if (parkingLot.getSlotAssignmentStrategyType().equals(SlotAssignmentStrategyType.RANDOM)) {
            factory = new RandomSlotAssignmentStrategyFactory();
        }

        ParkingSlot parkingSlot = factory.getSlotAssignmentStrategy()
                .assignSlot(parkingLot, vehicleType);
        ticket.setParkingSlot(parkingSlot);
        return ticketRepository.save(ticket);
    }
}
