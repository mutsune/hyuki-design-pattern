package interpreter.ex2301.interpreter.facade;

import interpreter.ex2301.interpreter.*;

public class Evaluator {

    private Evaluator() {
    }

    public static void run(String text, ExecutorFactory executorFactory) {
        Node node = new ProgramNode();
        try {
            Context context = new Context(text, executorFactory);
            node.parse(context);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        System.out.println("node = " + node);
        node.eval();
    }

}
