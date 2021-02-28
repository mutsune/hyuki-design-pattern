package interpreter.ex2301.interpreter;

public enum PrimitiveCommand {

    GO("go"),
    RIGHT("right"),
    LEFT("left"),
    ;

    private final String name;

    PrimitiveCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
