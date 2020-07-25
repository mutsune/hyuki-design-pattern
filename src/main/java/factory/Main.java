package factory;

import factory.framework.Factory;
import factory.framework.Product;
import factory.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("abc");
        Product card2 = factory.create("def");
        Product card3 = factory.create("ghe");
        card1.use();
        card2.use();
        card3.use();
    }
}
