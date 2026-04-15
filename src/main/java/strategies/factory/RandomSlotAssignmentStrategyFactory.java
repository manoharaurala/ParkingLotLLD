package strategies.factory;

import strategies.RandomSlotAssignmentStrategy;
import strategies.SlotAssignmentStrategy;

public class RandomSlotAssignmentStrategyFactory implements SlotAssignmentStrategyFactory {
    @Override
    public SlotAssignmentStrategy getSlotAssignmentStrategy() {
        return new RandomSlotAssignmentStrategy();
    }
}
