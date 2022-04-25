package hq.utils.movement.chain;

import hq.utils.movement.handler.LinearMovementHandler;
import hq.utils.movement.handler.backward.*;

public class BackwardMovementHandlerChainCreator {
    private static BackwardMovementHandlerChainCreator instance;
    final private LinearMovementHandler movementHandler;

    private BackwardMovementHandlerChainCreator() {
        BackwardNorthMovementHandler backwardNorthMovementCommandHandler = new BackwardNorthMovementHandler();
        BackwardSouthMovementHandler backwardSouthMovementCommandHandler = new BackwardSouthMovementHandler();
        BackwardEastMovementHandler backwardEastMovementCommandHandler = new BackwardEastMovementHandler();
        BackwardWestMovementHandler backwardWestMovementCommandHandler = new BackwardWestMovementHandler();
        backwardNorthMovementCommandHandler.next(backwardSouthMovementCommandHandler);
        backwardSouthMovementCommandHandler.next(backwardEastMovementCommandHandler);
        backwardEastMovementCommandHandler.next(backwardWestMovementCommandHandler);
        movementHandler = backwardNorthMovementCommandHandler;
    }

    public static BackwardMovementHandlerChainCreator getInstance(){
        if(instance == null){
            instance = new BackwardMovementHandlerChainCreator();
        }
        return instance;
    }

    public LinearMovementHandler getChain() {
        return movementHandler;
    }
}
