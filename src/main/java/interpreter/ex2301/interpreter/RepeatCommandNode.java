package interpreter.ex2301.interpreter;

/**
 * <repeat command> ::= repeat <number> <command list>
 */
public class RepeatCommandNode extends Node {

    private int number;
    private Node commandListNode;

    public int getNumber() {
        return number;
    }

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }

    @Override
    public void execute() {
        commandListNode.execute();
    }

}
