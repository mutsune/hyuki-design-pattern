package strategy.ex1004;

public class Main {

    public static void main(String[] args) {
        String[] data = {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };
        SortAndAPrint sap = new SortAndAPrint(data, new SelectionSorter());
        sap.execute();
    }

}
