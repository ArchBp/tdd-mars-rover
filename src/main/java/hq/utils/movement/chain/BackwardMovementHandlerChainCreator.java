package hq.utils.movement.chain;

import hq.utils.movement.handler.LinearMovementHandler;
import hq.utils.movement.handler.backward.*;
import hq.utils.movement.handler.forward.ForwardEastMovementHandler;
import hq.utils.movement.handler.forward.ForwardNorthMovementHandler;
import hq.utils.movement.handler.forward.ForwardSouthMovementHandler;
import hq.utils.movement.handler.forward.ForwardWestMovementHandler;

public class BackwardMovementHandlerChainCreator {
    private static BackwardMovementHandlerChainCreator instance;
    final private LinearMovementHandler movementHandler;

    private BackwardMovementHandlerChainCreator() {
        BackwardNorthMovementHandler backwardNorthMovementHandler = new BackwardNorthMovementHandler();
        ForwardNorthMovementHandler forwardNorthMovementHandler = new ForwardNorthMovementHandler();
        BackwardSouthMovementHandler backwardSouthMovementHandler = new BackwardSouthMovementHandler();
        ForwardSouthMovementHandler forwardSouthMovementHandler = new ForwardSouthMovementHandler();
        BackwardEastMovementHandler backwardEastMovementHandler = new BackwardEastMovementHandler();
        ForwardEastMovementHandler forwardEastMovementHandler = new ForwardEastMovementHandler();
        BackwardWestMovementHandler backwardWestMovementHandler = new BackwardWestMovementHandler();
        ForwardWestMovementHandler forwardWestMovementHandler = new ForwardWestMovementHandler();
        
        backwardNorthMovementHandler.next(backwardSouthMovementHandler);
        backwardNorthMovementHandler.stepBack(forwardNorthMovementHandler);
        backwardSouthMovementHandler.next(backwardEastMovementHandler);
        backwardSouthMovementHandler.stepBack(forwardSouthMovementHandler);
        backwardEastMovementHandler.next(backwardWestMovementHandler);
        backwardEastMovementHandler.stepBack(forwardEastMovementHandler);
        backwardWestMovementHandler.next(null);
        backwardWestMovementHandler.stepBack(forwardWestMovementHandler);
        movementHandler = backwardNorthMovementHandler;
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
