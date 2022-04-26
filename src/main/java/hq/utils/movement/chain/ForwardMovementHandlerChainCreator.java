package hq.utils.movement.chain;

import hq.utils.movement.handler.LinearMovementHandler;
import hq.utils.movement.handler.backward.BackwardEastMovementHandler;
import hq.utils.movement.handler.backward.BackwardNorthMovementHandler;
import hq.utils.movement.handler.backward.BackwardSouthMovementHandler;
import hq.utils.movement.handler.backward.BackwardWestMovementHandler;
import hq.utils.movement.handler.forward.ForwardEastMovementHandler;
import hq.utils.movement.handler.forward.ForwardNorthMovementHandler;
import hq.utils.movement.handler.forward.ForwardSouthMovementHandler;
import hq.utils.movement.handler.forward.ForwardWestMovementHandler;

public class ForwardMovementHandlerChainCreator {
    private static ForwardMovementHandlerChainCreator instance;
    final private LinearMovementHandler movementHandler;

    private ForwardMovementHandlerChainCreator() {
        ForwardNorthMovementHandler forwardNorthMovementHandler = new ForwardNorthMovementHandler();
        BackwardNorthMovementHandler backwardNorthMovementHandler = new BackwardNorthMovementHandler();
        ForwardSouthMovementHandler forwardSouthMovementHandler = new ForwardSouthMovementHandler();
        BackwardSouthMovementHandler backwardSouthMovementHandler = new BackwardSouthMovementHandler();
        ForwardEastMovementHandler forwardEastMovementHandler = new ForwardEastMovementHandler();
        BackwardEastMovementHandler backwardEastMovementHandler = new BackwardEastMovementHandler();
        ForwardWestMovementHandler forwardWestMovementHandler = new ForwardWestMovementHandler();
        BackwardWestMovementHandler backwardWestMovementHandler = new BackwardWestMovementHandler();

        forwardNorthMovementHandler.next(forwardSouthMovementHandler);
        forwardNorthMovementHandler.stepBack(backwardNorthMovementHandler);
        forwardSouthMovementHandler.next(forwardEastMovementHandler);
        forwardSouthMovementHandler.stepBack(backwardSouthMovementHandler);
        forwardEastMovementHandler.next(forwardWestMovementHandler);
        forwardEastMovementHandler.stepBack(backwardEastMovementHandler);
        forwardWestMovementHandler.next(null);
        forwardWestMovementHandler.stepBack(backwardWestMovementHandler);
        this.movementHandler = forwardNorthMovementHandler;
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
