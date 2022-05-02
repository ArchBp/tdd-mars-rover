package hq.command.handler.handler;

import hq.Rover;
import hq.command.handler.CommandChainExecutor;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.model.Position;

import java.util.List;

public class ForwardCommandHandler extends CommandHandler {

    public ForwardCommandHandler() {
        super(MOVE_FORWARD);
    }

    @Override
    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        if (this.command == command) {
            Position newCalculatedPosition = calculateNewPosition(rover);
            rover.moveTo(newCalculatedPosition, obstacles);
        }
    }

    public Position calculateNewPosition(Rover rover) {

        if (Direction.N == rover.getDirection()) {
            return moveForwardNorth(rover);
        } else if (Direction.E == rover.getDirection()) {
            return moveForwardEast(rover);
        } else if (Direction.S == rover.getDirection()) {
            return moveForwardSouth(rover);
        } else if (Direction.W == rover.getDirection()) {
            return moveForwardWest(rover);
        }
        return new Position(rover.getCoordinates(), rover.getDirection());
    }

    public Position moveForwardNorth(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (y == CommandChainExecutor.HIGH_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            return new Position(new Coordinates(x,y), Direction.S);
        } else {
            y++;
        }
        return new Position(new Coordinates(x,y), rover.getDirection());
    }

    public Position moveForwardSouth(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (y == CommandChainExecutor.LOW_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            return new Position(new Coordinates(x,y), Direction.N);
        } else {
            y--;
            return new Position(new Coordinates(x,y), rover.getDirection());
        }

    }

    public Position moveForwardEast(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (x == CommandChainExecutor.HIGH_EDGE) {
            x = CommandChainExecutor.LOW_EDGE;
        } else {
            x++;
        }
        return new Position(new Coordinates(x,y), rover.getDirection());
    }

    public Position moveForwardWest(Rover rover) {
        int x = rover.getCoordinates().getX();
        int y = rover.getCoordinates().getY();
        if (x == CommandChainExecutor.LOW_EDGE) {
            x = CommandChainExecutor.HIGH_EDGE;
        } else {
            x--;
        }
        return new Position(new Coordinates(x,y), rover.getDirection());
    }
}
