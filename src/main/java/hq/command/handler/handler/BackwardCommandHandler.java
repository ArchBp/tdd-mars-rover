package hq.command.handler.handler;

import hq.Rover;
import hq.command.handler.CommandChainExecutor;
import hq.enums.Direction;
import hq.model.Coordinates;

import java.util.List;

public class BackwardCommandHandler extends CommandHandler{

    public BackwardCommandHandler() {
        super(MOVE_BACKWARD);
    }

    @Override
    public void execute(char command, Rover rover, List<Coordinates> obstacles) {
        if(this.command == command){
            Coordinates coordinatesToBeReturned = calculateNewCoordinates(rover);
            rover.moveTo(coordinatesToBeReturned, obstacles);
        }
    }

    public Coordinates calculateNewCoordinates(Rover rover) {
        Coordinates coordinates = rover.getCoordinates();
        if (Direction.N == rover.getDirection()) {
            return moveBackwardNorth(rover, coordinates);
        }
        else if (Direction.S == rover.getDirection()) {
            return moveBackwardSouth(rover, coordinates);
        }
        else if (Direction.E == rover.getDirection()) {
            return moveBackwardEast(coordinates);
        }
        else if (Direction.W == rover.getDirection()) {
            return moveBackwardWest(coordinates);
        }
        return rover.getCoordinates();

    }

    public Coordinates moveBackwardWest(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (x == CommandChainExecutor.HIGH_EDGE) {
            x = CommandChainExecutor.LOW_EDGE;
        }
        else {
            x++;
        }
        return new Coordinates(x,y);
    }

    public Coordinates moveBackwardEast(Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (x == CommandChainExecutor.LOW_EDGE) {
            x = CommandChainExecutor.HIGH_EDGE;
        }
        else {
            x--;
        }
        return new Coordinates(x,y);
    }

    public Coordinates moveBackwardSouth(Rover rover, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (y == CommandChainExecutor.HIGH_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            rover.setDirection(Direction.N);
        } else {
            y++;
        }
        return new Coordinates(x,y);
    }

    public Coordinates moveBackwardNorth(Rover rover, Coordinates coordinates) {
        int x = coordinates.getX();
        int y = coordinates.getY();
        if (y == CommandChainExecutor.LOW_EDGE) {
            x = (CommandChainExecutor.HIGH_EDGE - x) + 1;
            rover.setDirection(Direction.S);
        } else {
            y--;
        }
        return new Coordinates(x,y);
    }
}
