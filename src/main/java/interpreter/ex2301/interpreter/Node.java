package interpreter.ex2301.interpreter;

public interface Node {

    void parse(Context context) throws ParseException;

    void eval();

}
