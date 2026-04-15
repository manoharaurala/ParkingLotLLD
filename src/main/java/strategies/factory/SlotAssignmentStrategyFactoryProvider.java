package strategies.factory;

import models.enums.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactoryProvider {
    private SlotAssignmentStrategyFactoryProvider() {
    }

    public static SlotAssignmentStrategyFactory getFactory(SlotAssignmentStrategyType strategyType) {
        if (strategyType == null) {
            throw new IllegalArgumentException("Slot assignment strategy type cannot be null");
        }

        return switch (strategyType) {
            case RANDOM -> new RandomSlotAssignmentStrategyFactory();
            case NEAREST, FARTHEST ->
                    throw new IllegalArgumentException("Slot assignment strategy is not implemented: " + strategyType);
        };
    }
}
