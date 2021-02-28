package interpreter.ex2301.canvas.executor;

import interpreter.ex2301.canvas.CarCanvas;
import interpreter.ex2301.canvas.car.CarPosition;
import interpreter.ex2301.canvas.car.Direction;
import interpreter.ex2301.executor.Executor;

import java.awt.*;

public class GoCarOperation implements Executor {

    private final CarCanvas carCanvas;

    public GoCarOperation(CarCanvas carCanvas) {
        this.carCanvas = carCanvas;
    }

    @Override
    public void execute() {
        carCanvas.move(drive(carCanvas.getPosition()));
        carCanvas.repaint();
    }

    private CarPosition drive(CarPosition current) {
        // change location only
        int unit = 50;
        int x = current.getX() + current.getDirection().x * unit;
        int y = current.getY() + current.getDirection().y * unit;
        Point nextLocation = new Point(x, y);
        Direction nextDirection = new Direction(current.getDirection().x, current.getDirection().y);

        System.out.println("go");
        System.out.println("loc: (" + current.getX() + ", " + current.getY() + ")");
        System.out.println("dir: (" + current.getDirection().x + ", " + current.getDirection().y + ")");

        return new CarPosition(nextLocation, nextDirection);
    }

}
