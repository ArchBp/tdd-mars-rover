package hq.command.handler.handler;

import hq.Rover;
import hq.command.handler.CommandChainExecutor;
import hq.enums.Direction;
import hq.model.Coordinates;
import hq.model.Position;

import java.util.List;

public class BackwardCommandHandler extends CommandHandler{

    public BackwardCommandHandler() {
        super(MOVE_BACKWARD);
    }

    @Override
    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        if(this.command == command){
            Position newCalculatedPosition = calculateNewPosition(rover);
            rover.moveTo(newCalculatedPosition, obstacles);
        }
    }

    public Position calculateNewPosition(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (Direction.N == rover.getDirection()) {
            return moveBackwardNorth(rover, coordinates);
        } else if (Direction.S == rover.getDirection()) {
            return moveBackwardSouth(rover, coordinates);
        } else if (Direction.E == rover.getDirection()) {
            return moveBackwardEast(rover, coordinates);
        } else if (Direction.W == rover.getDirection()) {
            return moveBackwardWest(rover, coordinates);
        }
        return new Position(rover.getCoordinates(), rover.getDirection());

    }

    public Position moveBackwardWest(Rover rover, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (x == CommandChainExecutor.HIGH_EDGE) {
            x = CommandChainExecutor.LOW_EDGE;
        } else {
            x++;
        }
        return new Position(new Coordinates(x,y), rover.getDirection());
    }

    public Position moveBackwardEast(Rover rover, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (x == CommandChainExecutor.LOW_EDGE) {
            x = CommandChainExecutor.HIGH_EDGE;
        }
        else {
            x--;
        }
        return new Position(new Coordinates(x,y), rover.getDirection());
    }

    public Position moveBackwardSouth(Rover rover, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (y == CommandChainExecutor.HIGH_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            return new Position(new Coordinates(x,y), Direction.N);
        } else {
            y++;
            return new Position(new Coordinates(x,y), rover.getDirection());
        }
    }

    public Position moveBackwardNorth(Rover rover, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (y == CommandChainExecutor.LOW_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            return new Position(new Coordinates(x,y), Direction.S);
        } else {
            y--;
            return new Position(new Coordinates(x,y), rover.getDirection());
        }
    }
}
