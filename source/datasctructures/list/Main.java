package datasctructures.list;

public class Main {

    public static void main(String[] args) {

        List<String> strings = new List<>();

        strings.addFirst("World");
        strings.addFirst("Hello");
        strings.addLast("!");
        strings.addLast(null);
        strings.addLast("Some text");
        strings.addLast("remove");
        strings.displayList();
        strings.displayInfo();

        System.out.println(strings.remove("remove"));
        System.out.println(strings.remove(null));
        strings.displayInfo();
        strings.displayList();
        System.out.println(strings.removeByIndex(3));
        System.out.println(strings.removeByIndex(0));
        System.out.println(strings.remove("!"));
        System.out.println(strings.remove("World"));
        strings.displayList();
        strings.displayInfo();


        strings.addLast("Java");
        strings.addLast("C++");
        strings.addLast("Java Script");
        strings.addLast("Python");
        strings.addLast("Python");
        strings.displayInfo();
        strings.displayList();
        System.out.println(strings.get(1));
        System.out.println(strings.get(3));
        System.out.println(strings.indexOf("Python"));
        System.out.println(strings.lastIndexOf("Python"));
        strings.clear();
        strings.displayInfo();
        strings.displayList();
    }

}
