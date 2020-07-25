package flyweight;

public class Main {
    public static void main(String[] args) {
        String string = "121-23";
        BigString bs = new BigString(string);
        bs.print();
    }
}
