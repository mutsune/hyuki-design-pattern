package interpreter.ex2301.interpreter;

import java.util.StringTokenizer;

public class Context {

    private final StringTokenizer tokenizer;
    private final ExecutorFactory executorFactory;

    private String currentToken;

    public Context(String text, ExecutorFactory executorFactory) {
        this.executorFactory = executorFactory;
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public void nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
    }

    public String currentToken() {
        return currentToken;
    }

    public void skipToken(String token) throws ParseException {
        if (!token.equals(currentToken)) {
            throw new ParseException("Warning: " + token + " is expected, but " + currentToken + " is found.");
        }
        nextToken();
    }

    public int currentNumber() throws ParseException {
        int number;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            throw new ParseException("Warning: " + e);
        }
        return number;
    }

    public ExecutorFactory getExecutorFactory() {
        return executorFactory;
    }

}
