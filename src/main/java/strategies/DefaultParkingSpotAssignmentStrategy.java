package strategies;

import models.ParkingFloor;
import models.ParkingSlot;
import models.enums.ParkingFloorStatus;
import models.enums.ParkingSlotStatus;
import models.enums.VehicleType;

import java.util.List;

public class DefaultParkingSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {

    @Override
    public ParkingSlot assignSlot(List<ParkingFloor> floors, VehicleType vehicleType) {
        for (ParkingFloor floor : floors) {
            if (floor.getStatus() != ParkingFloorStatus.OPEN) {
                continue;
            }
            for (ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.getStatus() == ParkingSlotStatus.AVAILABLE
                        && slot.getVehicleType() == vehicleType) {
                    return slot;
                }
            }
        }
        return null;
    }
}
