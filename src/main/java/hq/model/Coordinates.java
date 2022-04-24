package hq.model;

import java.util.Objects;

public class Coordinates {
    //Todo Hassen : Should keep Integer or use primitive ?
    private Integer x;
    private Integer y;

    public Coordinates(int x, int y) {
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
        //Todo Hassen : attention x and y could be null
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x.equals(that.x) &&
                y.equals(that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
