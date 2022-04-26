package hq.model;

import java.util.Objects;

public class Coordinates {
    public static final String X_COORDINATE_COULD_NOT_BE_NULL = "X coordinate could not be null";
    public static final String Y_COORDINATE_COULD_NOT_BE_NULL = "Y coordinate could not be null";
    private Integer x;
    private Integer y;

    public Coordinates(Integer x, Integer y) {
        Objects.requireNonNull(x, X_COORDINATE_COULD_NOT_BE_NULL);
        Objects.requireNonNull(y, Y_COORDINATE_COULD_NOT_BE_NULL);
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void incrementX(){
        x++;
    }

    public void decrementX(){
        x--;
    }

    public void incrementY(){
        y++;
    }

    public void decrementY(){
        y--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

    @Override
    public String toString() {
        return "coordinates (" +
                "x=" + x +
                ", y=" + y +
                ')';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);


    }
}
