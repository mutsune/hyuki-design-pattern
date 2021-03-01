package interpreter.ex2301.interpreter;

/**
 * <repeat command> ::= repeat <number> <command list>
 */
public class RepeatCommandNode implements Node {

    private int number;
    private Node commandListNode;

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
    public void eval() {
        for (int i = 0; i < number; i++) {
            commandListNode.eval();
        }
    }

}
