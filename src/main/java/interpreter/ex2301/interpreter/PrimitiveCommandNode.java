package interpreter.ex2301.interpreter;

import interpreter.ex2301.executor.Executor;

import java.util.Arrays;

/**
 * <primitive command> ::= go | right | left
 */
public class PrimitiveCommandNode implements Node {

    private PrimitiveCommand command;
    private Executor executor;

    public PrimitiveCommand getCommand() {
        return command;
    }

    @Override
    public void parse(Context context) throws ParseException {
        String name = context.currentToken();
        context.skipToken(name);

        command = Arrays.stream(PrimitiveCommand.values())
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ParseException(name + "is undefined"));

        ExecutorFactory executorFactory = context.getExecutorFactory();
        executor = executorFactory.create(this);
    }

    @Override
    public String toString() {
        return command.getName();
    }

    @Override
    public void eval() {
        executor.execute();
    }

}
