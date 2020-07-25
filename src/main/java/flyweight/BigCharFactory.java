package flyweight;

import java.util.HashMap;

public class BigCharFactory {
    private final HashMap<String, BigChar> pool = new HashMap<>();

    private static final BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory() {
    }

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public synchronized BigChar getBigChar(char charName) {
        String key = "" + charName;
        BigChar bc = pool.get(key);
        if (bc == null) {
            bc = new BigChar(charName);
            pool.put(key, bc);
        }
        return bc;
    }
}
