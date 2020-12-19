package visitor.ex1303;

public class Main {

    public static void main(String[] args) {
        try {
            Directory root1 = new Directory("root1");
            root1.add(new File("diary.html", 10));
            root1.add(new File("index.html", 20));

            Directory root2 = new Directory("root2");
            root2.add(new File("diary.html", 1000));
            root2.add(new File("index.html", 2000));

            ElementArrayList list = new ElementArrayList();
            list.add(root1);
            list.add(root2);
            list.add(new File("etc.html", 1234));

            list.accept(new ListVisitor());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }

        /*
        実行結果:
        /root1 (30)
        /root1/diary.html (10)
        /root1/index.html (20)
        /root2 (3000)
        /root2/diary.html (1000)
        /root2/index.html (2000)
        /etc.html (1234)
         */
    }

}
