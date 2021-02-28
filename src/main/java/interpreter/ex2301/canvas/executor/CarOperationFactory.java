package interpreter.ex2301.canvas.executor;

import interpreter.ex2301.canvas.CarCanvas;
import interpreter.ex2301.executor.Executor;
import interpreter.ex2301.executor.ExecutorFactory;
import interpreter.ex2301.interpreter.Node;
import interpreter.ex2301.interpreter.PrimitiveCommand;
import interpreter.ex2301.interpreter.PrimitiveCommandNode;

public class CarOperationFactory implements ExecutorFactory {

    private final CarCanvas canvas;

    public CarOperationFactory(CarCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Executor create(Node node) {
        PrimitiveCommand primitiveCommand = ((PrimitiveCommandNode) node).getCommand();
        return switch (primitiveCommand) {
            case GO -> new GoCarOperation(canvas);
            case RIGHT -> new RightCarOperation(canvas);
            case LEFT -> new LeftCarOperation(canvas);
        };
    }

}
