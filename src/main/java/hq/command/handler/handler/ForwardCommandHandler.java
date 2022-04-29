package hq.command.handler.handler;

import hq.Rover;
import hq.command.handler.CommandChainExecutor;
import hq.enums.Direction;
import hq.model.Coordinates;

import java.util.List;

public class ForwardCommandHandler extends CommandHandler {

    public ForwardCommandHandler() {
        super(MOVE_FORWARD);
    }

    @Override
    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        if (this.command == command) {
            Coordinates coordinatesToBeReturned = calculateNewCoordinates(rover);
            rover.moveTo(coordinatesToBeReturned, obstacles);
        }
    }

    public Coordinates calculateNewCoordinates(Rover rover) {

        if (Direction.N == rover.getDirection()) {
            return moveForwardNorth(rover);
        } else if (Direction.E == rover.getDirection()) {
            return moveForwardEast(rover);
        } else if (Direction.S == rover.getDirection()) {
            return moveForwardSouth(rover);
        } else if (Direction.W == rover.getDirection()) {
            return moveForwardWest(rover);
        }
        return rover.getCoordinates();
    }

    public Coordinates moveForwardWest(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (x == CommandChainExecutor.LOW_EDGE) {
            x = CommandChainExecutor.HIGH_EDGE;
        } else {
            x--;
        }
        return new Coordinates(x, y);
    }

    public Coordinates moveForwardSouth(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (y == CommandChainExecutor.LOW_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            rover.setDirection(Direction.N);
        } else {
            y--;
        }
        return new Coordinates(x, y);
    }

    public Coordinates moveForwardEast(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (x == CommandChainExecutor.HIGH_EDGE) {
            x = CommandChainExecutor.LOW_EDGE;
        } else {
            x++;
        }
        return new Coordinates(x, y);
    }

    public Coordinates moveForwardNorth(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (y == CommandChainExecutor.HIGH_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            rover.setDirection(Direction.S);
        } else {
            y++;
        }
        return new Coordinates(x, y);
    }
}
