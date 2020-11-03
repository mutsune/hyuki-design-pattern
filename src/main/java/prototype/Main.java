package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

public class Main {

    public static void main(String[] args) {
        // 準備
        Manager manager = new Manager();
        UndefinePen upen = new UndefinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        String upenName = "strong message";
        manager.register(upenName, upen);
        String mboxName = "warning box";
        manager.register(mboxName, mbox);
        String sboxName = "slash box";
        manager.register(sboxName, sbox);

        // 生成
        String message = "Hello, world.";

        Product p1 = manager.create(upenName);
        p1.use(message);
        System.out.println("");

        Product p2 = manager.create(mboxName);
        p2.use(message);
        System.out.println("");

        Product p3 = manager.create(sboxName);
        p3.use(message);
        System.out.println("");
    }

}
