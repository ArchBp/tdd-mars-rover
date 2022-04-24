package hq.model;

import hq.enums.Direction;

import java.util.Objects;

public class Position {
    private final Coordinates coordinates;
    private Direction direction;

    public Position(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getDirection() {
        return direction;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        //Todo Hassen : watch for null values
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(coordinates, position.coordinates) &&
                direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, direction);
    }

    @Override
    public String toString() {
        return "Position{" +
                "coordinates=" + coordinates +
                ", direction=" + direction +
                '}';
    }
}
