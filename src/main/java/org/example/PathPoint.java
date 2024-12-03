package org.example;

public class PathPoint {
    public int x;
    public int y;
    public DIRECTION direction;

    @Override
    public String toString() {
        return "PathPoint{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public PathPoint(int x, int y, DIRECTION d){
        this.x = x;
        this.y = y;
        this.direction = d;
    }
}
