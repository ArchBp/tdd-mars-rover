package hq;

import hq.enums.Direction;
import hq.exception.NullCommandException;
import hq.exception.UnknownCommandException;
import hq.model.Coordinates;

import java.util.List;
import java.util.Objects;

public class Rover {
    public static final char MOVE_BACKWARD = 'b';
    public static final char MOVE_FORWARD = 'f';
    public static final char TURN_RIGHT = 'r';
    public static final char TURN_LEFT = 'l';

    public static final int HIGH_EDGE = 5;
    public static final int LOW_EDGE = 1;

    private final List<Character> authorizedCommands = List.of('f', 'b', 'l', 'r');
    private final Coordinates coordinates;
    private Direction direction;


    public Rover(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinates move(char[] commands) {
        if(Objects.isNull(commands))
            throw new NullCommandException();
        for (char command : commands) {
            verifyCommand(command);
            if (TURN_RIGHT == command) {
                turnRight();
            } else if (TURN_LEFT == command) {
                turnLeft();
            } else if (MOVE_FORWARD == command) {
                moveForward();
            } else if (MOVE_BACKWARD == command) {
                moveBackward();
            }
        }
        return coordinates;
    }

    private void verifyCommand(char command) {
        if(!authorizedCommands.contains(command))
            throw new UnknownCommandException();
    }

    private void turnRight() {
        if (Direction.E == direction)
            this.setDirection(Direction.S);
        else if (Direction.S == direction)
            this.setDirection(Direction.W);
        else if (Direction.W == direction)
            this.setDirection(Direction.N);
        else
            this.setDirection(Direction.E);
    }

    private void turnLeft() {
        if (Direction.N == direction)
            this.setDirection(Direction.W);
        else if (Direction.W == direction)
            this.setDirection(Direction.S);
        else if (Direction.S == direction)
            this.setDirection(Direction.E);
        else
            this.setDirection(Direction.N);
    }

    private void moveForward() {
        if (Direction.N.equals(direction)) {
            if (coordinates.getY() == HIGH_EDGE) {
                coordinates.setX((HIGH_EDGE - coordinates.getX()) + 1);
                this.setDirection(Direction.S);
            } else {
                coordinates.incrementY();
            }
        } else if (Direction.S.equals(direction)) {
            if (coordinates.getY() == LOW_EDGE) {
                coordinates.setX((HIGH_EDGE - coordinates.getX()) + 1);
                this.setDirection(Direction.N);
            } else {
                coordinates.decrementY();
            }
        } else if (Direction.E.equals(direction)) {
            if (coordinates.getX() == HIGH_EDGE)
                coordinates.setX(LOW_EDGE);
            else
                coordinates.incrementX();
        } else if (Direction.W.equals(direction)) {
            if (coordinates.getX() == LOW_EDGE)
                coordinates.setX(HIGH_EDGE);
            else
                coordinates.decrementX();
        }
    }

    private void moveBackward() {
        if (Direction.N.equals(direction))
            if (coordinates.getY() == LOW_EDGE) {
                coordinates.setX((HIGH_EDGE - coordinates.getX()) + 1);
                this.setDirection(Direction.S);
            } else {
                coordinates.decrementY();
            }
        else if (Direction.S.equals(direction))
            if (coordinates.getY() == HIGH_EDGE) {
                coordinates.setX((HIGH_EDGE - coordinates.getX()) + 1);
                this.setDirection(Direction.N);
            } else {
                coordinates.incrementY();
            }
        else if (Direction.E.equals(direction))
            if (coordinates.getX() == LOW_EDGE)
                coordinates.setX(HIGH_EDGE);
            else
                coordinates.decrementX();
        else if (Direction.W.equals(direction))
            if (coordinates.getX() == HIGH_EDGE)
                coordinates.setX(LOW_EDGE);
            else
                coordinates.incrementX();
    }
}
