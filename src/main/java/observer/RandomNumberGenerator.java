package observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private int number;
    private final Random random;

    public RandomNumberGenerator() {
        random = new Random();
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            notifyObservers();
        }
    }
}
