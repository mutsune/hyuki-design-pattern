package interpreter.ex2301.canvas.car;

import java.awt.*;

public class CarPosition {

    private final Point location;
    private final Direction direction;

    public CarPosition(Point location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public CarPosition(Point location) {
        this(location, new Direction(0, -1));
    }

    public int getX() {
        return location.x;
    }

    public int getY() {
        return location.y;
    }

    public Direction getDirection() {
        return direction;
    }

}
