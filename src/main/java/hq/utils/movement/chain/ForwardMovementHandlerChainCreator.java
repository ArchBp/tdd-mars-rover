package hq.utils.movement.chain;

import hq.utils.movement.handler.LinearMovementHandler;
import hq.utils.movement.handler.forward.ForwardEastMovementHandler;
import hq.utils.movement.handler.forward.ForwardNorthMovementHandler;
import hq.utils.movement.handler.forward.ForwardSouthMovementHandler;
import hq.utils.movement.handler.forward.ForwardWestMovementHandler;

public class ForwardMovementHandlerChainCreator {
    private static ForwardMovementHandlerChainCreator instance;
    final private LinearMovementHandler movementHandler;

    private ForwardMovementHandlerChainCreator() {
        ForwardNorthMovementHandler forwardNorthMovementHandler = new ForwardNorthMovementHandler();
        ForwardSouthMovementHandler forwardSouthMovementHandler = new ForwardSouthMovementHandler();
        forwardNorthMovementHandler.next(forwardSouthMovementHandler);
        ForwardEastMovementHandler forwardEastMovementHandler = new ForwardEastMovementHandler();
        forwardSouthMovementHandler.next(forwardEastMovementHandler);
        ForwardWestMovementHandler forwardWestMovementHandler = new ForwardWestMovementHandler();
        forwardEastMovementHandler.next(forwardWestMovementHandler);
        movementHandler = forwardNorthMovementHandler;
    }

    public static ForwardMovementHandlerChainCreator getInstance(){
        if(instance == null){
            instance = new ForwardMovementHandlerChainCreator();
        }
        return instance;
    }

    public LinearMovementHandler getChain() {
        return movementHandler;
    }


}
