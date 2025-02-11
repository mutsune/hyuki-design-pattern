package interpreter.ex2301.interpreter;

/**
 * <command> ::= <repeat command> | <primitive command>
 */
public class CommandNode implements Node {

    private Node node;

    public Node getNode() {
        return node;
    }

    @Override
    public void parse(Context context) throws ParseException {
        if (context.currentToken().equals("repeat")) {
            node = new RepeatCommandNode();
        } else {
            node = new PrimitiveCommandNode();
        }
        node.parse(context);
    }

    @Override
    public String toString() {
        return node.toString();
    }

    @Override
    public void eval() {
        node.eval();
    }

}
