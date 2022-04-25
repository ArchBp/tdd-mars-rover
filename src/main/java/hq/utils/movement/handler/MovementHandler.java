package hq.utils.movement.handler;

import hq.Rover;

public abstract class MovementHandler {
    private MovementHandler nextMovementHandler;

    public void next(MovementHandler movementHandler) {
        this.nextMovementHandler = movementHandler;
    }

    public abstract void move(Rover rover);

    public MovementHandler getNextMovementHandler() {
        return nextMovementHandler;
    }
}
