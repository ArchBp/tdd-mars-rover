package hq;

import hq.enums.Direction;
import hq.model.Coordinates;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test
    void mustMoveRoverForwardInTheNorthDirection() {
        Coordinates startingPoint = new Coordinates(1,1);
        final Rover rover = new Rover(startingPoint, Direction.N);
        Coordinates newCoordinates = rover.move('f');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(2);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsHeadingWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Rover rover = new Rover(startingPoint, Direction.W);
        Coordinates newCoordinates = rover.move('f');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsHeadingEast() {
        Coordinates startingPoint = new Coordinates(5,1);
        final Rover rover = new Rover(startingPoint, Direction.E);
        Coordinates newCoordinates = rover.move('f');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustMoveRoverForwardInTheSouthDirection() {
        Coordinates startingPoint = new Coordinates(1,4);
        final Rover rover = new Rover(startingPoint, Direction.S);
        Coordinates newCoordinates = rover.move('f');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(3);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void mustMoveRoverForwardHInTheEastDirection() {
        Coordinates startingPoint = new Coordinates(1,4);
        final Rover rover = new Rover(startingPoint, Direction.E);
        Coordinates newCoordinates = rover.move('f');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(4);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(2);
    }

    @Test
    void mustMoveRoverForwardInTheWestDirection() {
        Coordinates startingPoint = new Coordinates(2,4);
        final Rover rover = new Rover(startingPoint, Direction.W);
        Coordinates newCoordinates = rover.move('f');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(4);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void mustConnectToHorizontalEdgeWhenRoverIsHeadingNorth() {
        Assertions.fail("not implemented");
    }

    @Test
    void mustConnectToHorizontalEdgeWhenRoverIsHeadingSouth() {
        Assertions.fail("not implemented");
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingNorth() {
        Coordinates startingPoint = new Coordinates(1,2);
        final Rover rover = new Rover(startingPoint, Direction.N);
        Coordinates newCoordinates = rover.move('b');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingSouth() {
        Coordinates startingPoint = new Coordinates(1,1);
        final Rover rover = new Rover(startingPoint, Direction.S);
        Coordinates newCoordinates = rover.move('b');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(2);
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingEast() {
        Coordinates startingPoint = new Coordinates(2,1);
        final Rover rover = new Rover(startingPoint, Direction.E);
        Coordinates newCoordinates = rover.move('b');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingWest() {
        Coordinates startingPoint = new Coordinates(1,1);
        final Rover rover = new Rover(startingPoint, Direction.W);
        Coordinates newCoordinates = rover.move('b');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(2);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsMovingInTheWestDirectionBackward() {
        Coordinates startingPoint = new Coordinates(5,1);
        final Rover rover = new Rover(startingPoint, Direction.W);
        Coordinates newCoordinates = rover.move('b');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(1);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsMovingInTheEastDirectionBackward() {
        Coordinates startingPoint = new Coordinates(1,1);
        final Rover rover = new Rover(startingPoint, Direction.E);
        Coordinates newCoordinates = rover.move('b');
        Assertions.assertThat(newCoordinates).isNotNull();
        Assertions.assertThat(newCoordinates.getX()).isEqualTo(5);
        Assertions.assertThat(newCoordinates.getY()).isEqualTo(1);
    }

    @Test
    void mustTurnRoverFromNorthDirectionToEastDirection() {
        Assertions.fail("Not implemented");
    }
}
