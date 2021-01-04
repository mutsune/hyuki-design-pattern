package facade.pagemaker;

import java.io.IOException;
import java.util.Properties;

public class Database {

    private Database() {
    }

    public static Properties getProperties(String dbName) {
        String filename = dbName + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(Database.class.getResourceAsStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: cannot load " + filename);
        }
        return prop;
    }

}
