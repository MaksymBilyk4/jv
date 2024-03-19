package udemy.nested;

public class Outer {

    protected int value;
    protected Inner inner;

    public Outer(int value, int valueInner) {
        this.value = value;
        this.inner = this.new Inner(valueInner);
    }

    class Inner {

        public static int a = 5;

        public int value;


        public Inner(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Outer{" +
                "value=" + value +
                ", inner=" + inner +
                '}';
    }
}

class Test1 {

    public static void main(String[] args) {

        Outer outer = new Outer(10, 20);
        System.out.println(outer);

    }

}