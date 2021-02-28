package interpreter.ex2301.interpreter;

import interpreter.ex2301.executor.Executable;

import java.util.ArrayList;

/**
 * <command list> ::= <command>* end
 */
public class CommandListNode extends Node {

    private final ArrayList<Node> list = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true) {
            if (context.currentToken() == null) {
                throw new ParseException("Missing 'end'");
            } else if (context.currentToken().equals("end")) {
                context.skipToken("end");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public void execute() {
        list.forEach(Executable::execute);
    }

}
