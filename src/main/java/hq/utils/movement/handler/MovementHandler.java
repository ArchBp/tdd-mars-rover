package hq.utils.movement.handler;

import hq.Rover;

public abstract class MovementHandler {
    private MovementHandler nextMovementHandler;
    private MovementHandler stepBackMovementHandler;

    public abstract void move(Rover rover);

    public void next(MovementHandler movementHandler) {
        this.nextMovementHandler = movementHandler;
    }

    public void stepBack(MovementHandler movementHandler){
        this.stepBackMovementHandler = movementHandler;
    }

    public MovementHandler getNextMovementHandler() {
        return nextMovementHandler;
    }

    public MovementHandler getStepBackMovementHandler() {
        return stepBackMovementHandler;
    }
}
