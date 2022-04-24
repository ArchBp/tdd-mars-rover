package hq;

import hq.enums.Direction;
import hq.model.Coordinates;
import hq.model.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RoverTest {

    private static Stream<Arguments> generateMultiRoverCommandsScenarios() {
        return Stream.of(
                Arguments.of(new Position(new Coordinates(1, 1), Direction.N),
                        new char[]{'f', 'f', 'r', 'f', 'f', 'l', 'f'},
                        new Position(new Coordinates(3, 4), Direction.N)),
                Arguments.of(new Position(new Coordinates(1, 1), Direction.E),
                        new char[]{'b', 'b', 'l', 'f', 'f', 'l', 'b', 'b'},
                        new Position(new Coordinates(1, 3), Direction.W)),
                Arguments.of(new Position(new Coordinates(4, 1), Direction.E),
                        new char[]{'f', 'f', 'l', 'f', 'f', 'l', 'f'},
                        new Position(new Coordinates(5, 3), Direction.W))
        );
    }

    @Test
    void mustMoveRoverForwardInTheNorthDirection() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.N);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('f');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(2);
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsHeadingWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.W);
        final Rover rover = new Rover(initialPosition);
        Position newPosition = rover.move('f');
        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(5);
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsHeadingEast() {
        Coordinates startingPoint = new Coordinates(5, 1);
        final Position initialPosition = new Position(startingPoint, Direction.E);
        final Rover rover = new Rover(initialPosition);
        Position newPosition = rover.move('f');
        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(1);
    }

    @Test
    void mustMoveRoverForwardInTheSouthDirection() {
        Coordinates startingPoint = new Coordinates(1, 4);
        final Position initialPosition = new Position(startingPoint, Direction.S);
        final Rover rover = new Rover(initialPosition);
        Position newPosition = rover.move('f');
        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(3);
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
    }

    @Test
    void mustMoveRoverForwardHInTheEastDirection() {
        Coordinates startingPoint = new Coordinates(1, 4);
        final Position initialPosition = new Position(startingPoint, Direction.E);
        final Rover rover = new Rover(initialPosition);
        Position newPosition = rover.move('f');
        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(4);
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(2);
    }

    @Test
    void mustMoveRoverForwardInTheWestDirection() {
        Coordinates startingPoint = new Coordinates(2, 4);
        final Position initialPosition = new Position(startingPoint, Direction.W);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('f');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(4);
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
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
        Coordinates startingPoint = new Coordinates(1, 2);
        final Position initialPosition = new Position(startingPoint, Direction.N);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('b');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(1);
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingSouth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.S);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('b');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(2);
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingEast() {
        Coordinates startingPoint = new Coordinates(2, 1);
        final Position initialPosition = new Position(startingPoint, Direction.E);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('b');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(1);
    }

    @Test
    void testMovingBackwardWhenRoverIsHeadingWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.W);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('b');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(2);
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsMovingInTheWestDirectionBackward() {
        Coordinates startingPoint = new Coordinates(5, 1);
        final Position initialPosition = new Position(startingPoint, Direction.W);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('b');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(1);
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(1);
    }

    @Test
    void mustConnectToVerticalEdgeWhenRoverIsMovingInTheEastDirectionBackward() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.E);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('b');

        Assertions.assertThat(newPosition).isNotNull();
        Assertions.assertThat(newPosition.getCoordinates().getX()).isEqualTo(5);
        Assertions.assertThat(newPosition.getCoordinates().getY()).isEqualTo(1);
    }

    @Test
    void mustTurnRoverFromNorthToEast() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.N);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('r');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.E);
    }

    @Test
    void mustTurnRoverFromEastToSouth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.E);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('r');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    void mustTurnRoverFromSouthToWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.S);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('r');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.W);
    }

    @Test
    void mustTurnRoverFromWestToNorth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.W);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('r');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.N);
    }

    @Test
    void mustTurnRoverFromEastToNorth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.E);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('l');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.N);
    }

    @Test
    void mustTurnRoverFromSouthToEast() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.S);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('l');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.E);
    }

    @Test
    void mustTurnRoverFromWestToSouth() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.W);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('l');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.S);
    }

    @Test
    void mustTurnRoverFromNorthToWest() {
        Coordinates startingPoint = new Coordinates(1, 1);
        final Position initialPosition = new Position(startingPoint, Direction.N);
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move('l');

        Assertions.assertThat(newPosition.getDirection()).isEqualTo(Direction.W);
    }

    @ParameterizedTest
    @MethodSource("generateMultiRoverCommandsScenarios")
    void mustReturnExpectedPositionAfterMultipleCommands(Position initialPosition, char[] commands, Position expectedFinalPosition) {
        final Rover rover = new Rover(initialPosition);

        Position newPosition = rover.move(commands);

        Assertions.assertThat(newPosition).isEqualTo(expectedFinalPosition);
    }

    @Test
    void mustTestUnknownCommands() {
        Assertions.fail("Not implemented");
    }

    @Test
    void mustTestNullCommands() {
        Assertions.fail("Not implemented");
    }

    @Test
    void dontForgetEdgeCases() {
        Assertions.fail("Not implemented");
    }
}
