package interpreter.ex2301.executor;

import interpreter.ex2301.interpreter.Node;

public interface ExecutorFactory {

    Executor create(Node node);

}
