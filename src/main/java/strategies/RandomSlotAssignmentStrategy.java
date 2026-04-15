package strategies;

import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingSlot;
import models.enums.ParkingLotStatus;
import models.enums.ParkingSlotStatus;
import models.enums.VehicleType;

public class RandomSlotAssignmentStrategy implements SlotAssignmentStrategy {
    @Override
    public ParkingSlot assignSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
                if (parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY)
                        && parkingSlot.getVehicleType().equals(vehicleType)) {
                    parkingLot.setParkingLotStatus(ParkingLotStatus.FILLED);
                    return parkingSlot;
                }
            }
        }
        return null;
    }
}
