package datasctructures.linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.insert(0, 111);
        list.insert(0, 333);
        list.insert(0, 222);
        list.addFirst(123);
        list.addLast(999);

        list.displayList();

        list.clear();
        list.displayList();

    }

}
