package observer.ex1702;

public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {
        }
    }
}
