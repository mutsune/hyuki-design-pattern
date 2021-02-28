package interpreter.ex2301.canvas.executor;

import interpreter.ex2301.canvas.CarCanvas;
import interpreter.ex2301.canvas.car.CarPosition;
import interpreter.ex2301.canvas.car.Direction;
import interpreter.ex2301.executor.Executor;

import java.awt.*;

public class RightCarOperation implements Executor {

    private final CarCanvas carCanvas;

    public RightCarOperation(CarCanvas carCanvas) {
        this.carCanvas = carCanvas;
    }

    @Override
    public void execute() {
        carCanvas.move(drive(carCanvas.getPosition()));
        carCanvas.repaint();
    }

    private CarPosition drive(CarPosition current) {
        // change direction only
        int x = -current.getDirection().y;
        int y = current.getDirection().x;
        Point nextLocation = new Point(current.getX(), current.getY());
        Direction nextDirection = new Direction(x, y);

        System.out.println("right");
        System.out.println("loc: (" + current.getX() + ", " + current.getY() + ")");
        System.out.println("dir: (" + current.getDirection().x + ", " + current.getDirection().y + ")");

        return new CarPosition(nextLocation, nextDirection);
    }

}
