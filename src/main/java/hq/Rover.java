package hq;

import hq.enums.Direction;
import hq.model.Coordinates;
import hq.model.Position;

public class Rover {
    public static final char MOVE_BACKWARD = 'b';
    public static final char MOVE_FORWARD = 'f';
    public static final char TURN_RIGHT = 'r';
    public static final char TURN_LEFT = 'l';
    public static final int EDGE_ONE = 1;
    public static final int EDGE_FIVE = 5;
    private final Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public Position move(char... commands) {
        for (char command : commands) {
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
        return position;
    }

    private void turnRight() {
        if (Direction.E == position.getDirection())
            position.setDirection(Direction.S);
        else if (Direction.S == position.getDirection())
            position.setDirection(Direction.W);
        else if (Direction.W == position.getDirection())
            position.setDirection(Direction.N);
        else
            position.setDirection(Direction.E);
    }

    private void turnLeft() {
        if (Direction.N == position.getDirection())
            position.setDirection(Direction.W);
        else if (Direction.W == position.getDirection())
            position.setDirection(Direction.S);
        else if (Direction.S == position.getDirection())
            position.setDirection(Direction.E);
        else
            position.setDirection(Direction.N);
    }

    private void moveForward() {
        Coordinates coordinates = position.getCoordinates();
        Direction direction = position.getDirection();
        if (Direction.N.equals(direction)) {
            if(coordinates.getY() == EDGE_FIVE){
                coordinates.setX(6 - coordinates.getX());
                position.setDirection(Direction.S);
            } else {
                coordinates.incrementY();
            }
        } else if (Direction.S.equals(direction)) {
            if(coordinates.getY() == EDGE_ONE){
                coordinates.setX(6 - coordinates.getX());
                position.setDirection(Direction.N);
            } else {
                coordinates.decrementY();
            }
        } else if (Direction.E.equals(direction)) {
            if (coordinates.getX() == EDGE_FIVE)
                coordinates.setX(EDGE_ONE);
            else
                coordinates.incrementX();
        } else if (Direction.W.equals(direction)) {
            if (coordinates.getX() == EDGE_ONE)
                coordinates.setX(EDGE_FIVE);
            else
                coordinates.decrementX();
        }
    }

    private void moveBackward() {
        Coordinates coordinates = position.getCoordinates();
        Direction direction = position.getDirection();
        if (Direction.N.equals(direction))
            if(coordinates.getY() == EDGE_ONE){
                coordinates.setX(6 - coordinates.getX());
                position.setDirection(Direction.S);
            } else {
                coordinates.decrementY();
            }
        else if (Direction.S.equals(direction))
            if(coordinates.getY() == EDGE_FIVE){
                coordinates.setX(6 - coordinates.getX());
                position.setDirection(Direction.N);
            } else {
                coordinates.incrementY();
            }
        else if (Direction.E.equals(direction))
            if (coordinates.getX() == EDGE_ONE)
                coordinates.setX(EDGE_FIVE);
            else
                coordinates.decrementX();
        else if (Direction.W.equals(direction))
            if (coordinates.getX() == EDGE_FIVE)
                coordinates.setX(EDGE_ONE);
            else
                coordinates.incrementX();
    }
}
