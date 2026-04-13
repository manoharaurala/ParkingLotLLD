import controllers.TicketController;
import dtos.IssueTicketRequestDTO;
import dtos.IssueTicketResponseDTO;
import models.*;
import models.enums.*;

import java.util.List;

public class Client {

    public static void main(String[] args) {
        // --- Setup operators ---
        Operator operator1 = new Operator("Alice", "alice@parking.com", "pass123");
        operator1.setId(1);

        Operator operator2 = new Operator("Bob", "bob@parking.com", "pass456");
        operator2.setId(2);

        // --- Setup gates ---
        Gate entryGate = new Gate(1, GateType.ENTRY, GateStatus.OPEN, operator1);
        entryGate.setId(1);

        Gate exitGate = new Gate(2, GateType.EXIT, GateStatus.OPEN, operator2);
        exitGate.setId(2);

        // --- Setup parking slots (Floor 1) ---
        ParkingSlot carSlot1 = new ParkingSlot(101, VehicleType.CAR);
        carSlot1.setId(101);

        ParkingSlot carSlot2 = new ParkingSlot(102, VehicleType.CAR);
        carSlot2.setId(102);

        ParkingSlot bikeSlot1 = new ParkingSlot(201, VehicleType.BIKE);
        bikeSlot1.setId(201);

        ParkingSlot truckSlot1 = new ParkingSlot(301, VehicleType.TRUCK);
        truckSlot1.setId(301);

        // --- Setup parking floor ---
        ParkingFloor floor1 = new ParkingFloor(1, List.of(carSlot1, carSlot2, bikeSlot1, truckSlot1));
        floor1.setId(1);

        // --- Setup supported vehicle types with pricing ---
        SupportedVehicleType carType = new SupportedVehicleType(VehicleType.CAR, 50.0);
        SupportedVehicleType bikeType = new SupportedVehicleType(VehicleType.BIKE, 20.0);
        SupportedVehicleType truckType = new SupportedVehicleType(VehicleType.TRUCK, 100.0);

        // --- Setup parking lot ---
        ParkingLot parkingLot = new ParkingLot(
                "Central Parking",
                "123 Main Street, City",
                List.of(entryGate, exitGate),
                List.of(floor1),
                List.of(carType, bikeType, truckType)
        );
        parkingLot.setId(1);

        System.out.println("Parking lot created: " + parkingLot);
        System.out.println();

        // --- Setup controller ---
        TicketController ticketController = new TicketController(parkingLot);

        // --- Scenario 1: Issue ticket for a CAR ---
        System.out.println("=== Scenario 1: Car arrives at Entry Gate ===");
        IssueTicketRequestDTO carRequest = new IssueTicketRequestDTO("MH-12-AB-1234", VehicleType.CAR, 1, 1);
        IssueTicketResponseDTO carResponse = ticketController.issueTicket(carRequest);
        System.out.println("Response: " + carResponse);
        System.out.println();

        // --- Scenario 2: Issue ticket for a BIKE ---
        System.out.println("=== Scenario 2: Bike arrives at Entry Gate ===");
        IssueTicketRequestDTO bikeRequest = new IssueTicketRequestDTO("MH-12-CD-5678", VehicleType.BIKE, 1, 1);
        IssueTicketResponseDTO bikeResponse = ticketController.issueTicket(bikeRequest);
        System.out.println("Response: " + bikeResponse);
        System.out.println();

        // --- Scenario 3: Issue ticket for another CAR ---
        System.out.println("=== Scenario 3: Second Car arrives at Entry Gate ===");
        IssueTicketRequestDTO carRequest2 = new IssueTicketRequestDTO("DL-01-EF-9999", VehicleType.CAR, 1, 1);
        IssueTicketResponseDTO carResponse2 = ticketController.issueTicket(carRequest2);
        System.out.println("Response: " + carResponse2);
        System.out.println();

        // --- Scenario 4: No more CAR slots available ---
        System.out.println("=== Scenario 4: Third Car arrives (no slots available) ===");
        IssueTicketRequestDTO carRequest3 = new IssueTicketRequestDTO("KA-05-GH-1111", VehicleType.CAR, 1, 1);
        IssueTicketResponseDTO carResponse3 = ticketController.issueTicket(carRequest3);
        System.out.println("Response: " + carResponse3);
        System.out.println();

        // --- Scenario 5: Invalid gate ID ---
        System.out.println("=== Scenario 5: Vehicle arrives at invalid gate ===");
        IssueTicketRequestDTO invalidGateRequest = new IssueTicketRequestDTO("TN-09-IJ-2222", VehicleType.CAR, 99, 1);
        IssueTicketResponseDTO invalidGateResponse = ticketController.issueTicket(invalidGateRequest);
        System.out.println("Response: " + invalidGateResponse);
    }
}
