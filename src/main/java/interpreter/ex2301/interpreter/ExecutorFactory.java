package interpreter.ex2301.interpreter;

import interpreter.ex2301.executor.Executor;

public interface ExecutorFactory {

    Executor create(Node node);

}
