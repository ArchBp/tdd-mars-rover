package hq.utils.movement.chain;

import hq.utils.movement.handler.LinearMovementHandler;
import hq.utils.movement.handler.backward.BackwardEastMovementHandler;
import hq.utils.movement.handler.backward.BackwardNorthMovementHandler;
import hq.utils.movement.handler.backward.BackwardSouthMovementHandler;
import hq.utils.movement.handler.backward.BackwardWestMovementHandler;

public class BackwardMovementHandlerChainCreator {
    private static BackwardMovementHandlerChainCreator instance;
    final private LinearMovementHandler movementHandler;

    private BackwardMovementHandlerChainCreator() {
        BackwardNorthMovementHandler backwardNorthMovementHandler = new BackwardNorthMovementHandler();
        BackwardSouthMovementHandler backwardSouthMovementHandler = new BackwardSouthMovementHandler();
        BackwardEastMovementHandler backwardEastMovementHandler = new BackwardEastMovementHandler();
        BackwardWestMovementHandler backwardWestMovementHandler = new BackwardWestMovementHandler();

        backwardNorthMovementHandler.next(backwardSouthMovementHandler);
        backwardSouthMovementHandler.next(backwardEastMovementHandler);
        backwardEastMovementHandler.next(backwardWestMovementHandler);
        backwardWestMovementHandler.next(null);
        movementHandler = backwardNorthMovementHandler;
    }

    public static BackwardMovementHandlerChainCreator getInstance() {
        if (instance == null) {
            instance = new BackwardMovementHandlerChainCreator();
        }
        return instance;
    }

    public LinearMovementHandler getChain() {
        return movementHandler;
    }
}
