package interpreter.ex2301.interpreter;

import interpreter.ex2301.executor.Executable;

public abstract class Node implements Executable {

    public abstract void parse(Context context) throws ParseException;

}
