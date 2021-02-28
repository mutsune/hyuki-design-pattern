package interpreter.ex2301.interpreter;

/**
 * <program> ::= program <command list>
 */
public class ProgramNode extends Node {

    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("program");
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[program " + commandListNode + "]";
    }

    @Override
    public void execute() {
        commandListNode.execute();
    }

}
