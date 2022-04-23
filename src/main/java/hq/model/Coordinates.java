package hq.model;

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
}
