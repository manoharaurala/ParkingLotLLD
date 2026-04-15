package strategies;

import models.ParkingLot;
import models.ParkingSlot;
import models.enums.VehicleType;

public interface SlotAssignmentStrategy {
    ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
