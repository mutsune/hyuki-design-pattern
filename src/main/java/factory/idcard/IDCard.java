package factory.idcard;

import factory.framework.Product;

public class IDCard extends Product {
    private final String owner;

    IDCard(String owner) {
        System.out.println(owner + "のカードを作ります。");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println(owner + "のカードを使います。");
    }

    public String getOwner() {
        return owner;
    }
}
