package interpreter.ex2301.canvas.car;

public class Direction {

    private final static int NORTH = 0;
    private final static int EAST = 90;
    private final static int SOUTH = 180;
    private final static int WEST = 270;

    public int x;
    public int y;

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getAngle() {
        if (x == 0 && y == -1) {
            return NORTH;
        }
        if (x == 1 && y == 0) {
            return EAST;
        }
        if (x == 0 && y == 1) {
            return SOUTH;
        }
        if (x == -1 && y == 0) {
            return WEST;
        }

        throw new RuntimeException("Unsupported angle: " + x + ", " + y);
    }

}
