package udemy.nested;

public class Anon {

    public static void main(String[] args) {


        // use lambda
        Math1 m = new Math1() {
            @Override
            public double doOperation(int a, int b) {
                return a + b;
            }
        };

        System.out.println(
                m.doOperation(10, 20));

//        Test3<String> t = new Test3<>() {};
//        t.abc("fdshfgdskjhfgdsjhfds");

        Test3<String> t1 = (s) -> System.out.println(s);

        t1.def("labmda");

    }

}


interface Math1 {

    double doOperation(int a, int b);

}

interface Test3<T> {

    void def(T t);

    default void abc(T something) {
        System.out.println(something);
    }

}