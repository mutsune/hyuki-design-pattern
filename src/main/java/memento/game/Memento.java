package memento.game;

import java.util.ArrayList;
import java.util.List;

public class Memento {

    int money;
    ArrayList<String> fruits;

    // wide interface
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    // wide interface
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // wide interface
    @SuppressWarnings("unchecked")
    List<String> getFruits() {
        return (List<String>) fruits.clone();
    }

    // narrow interface
    public int getMoney() {
        return money;
    }

}
