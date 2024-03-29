package datasctructures.arraylist;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println(arrayList.isEmpty());
        arrayList.add(1);
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains(21));
    }

}
