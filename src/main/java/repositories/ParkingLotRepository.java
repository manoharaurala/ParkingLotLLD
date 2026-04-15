package repositories;

import models.Gate;
import models.ParkingLot;

import java.util.TreeMap;

public class ParkingLotRepository {
    private final TreeMap<Integer, ParkingLot> parkingLots = new TreeMap<>();

    public ParkingLot findParkingLotByEntryGate(Gate gateToCheck) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            for (Gate gate : parkingLot.getEntryGates()) {
                if (gate.getId() == gateToCheck.getId()) {
                    return parkingLot;
                }
            }
        }
        return null;
    }

    public ParkingLot findParkingLotById(Long parkingLotId) {
        if (parkingLots.containsKey(parkingLotId)) {
            return parkingLots.get(parkingLotId);
        }

        return null;
    }
}
