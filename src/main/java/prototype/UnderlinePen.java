package prototype;

import prototype.framework.Product;

public class UnderlinePen implements Product {

    private char underlineChar;

    public UnderlinePen(char underlineChar) {
        this.underlineChar = underlineChar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(underlineChar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) { // Cloneable を実装していないと例外が発生する
            e.printStackTrace();
        }
        return p;
    }

}
