package strategies;

import models.ParkingFloor;
import models.ParkingSlot;
import models.enums.VehicleType;

import java.util.List;

public interface ParkingSpotAssignmentStrategy {
    ParkingSlot assignSlot(List<ParkingFloor> floors, VehicleType vehicleType);
}
