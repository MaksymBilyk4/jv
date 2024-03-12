package udemy.testing_classes;

public class Outer {

    public static int count = 10;

    public class Inner {

        public Inner() {
            System.out.println("public class Inner constructor");
        }

        public int getCount() {
            return count;
        }
    }

    private static class Immersed {
        public static int count = 20;

        public int getCount() {
            return Outer.count + count;
        }

        public Immersed() {
            System.out.println("private static class Immersed");
        }

    }

    public void testLocalClass(int n1, int n2) {

        class LocalSum {

            private int n1;
            private int n2;

            public LocalSum(int n1, int n2) {
                this.n1 = n1;
                this.n2 = n2;
            }

            public void displaySum() {
                System.out.println("Sum of provided numbers ---> " + (this.n1 + this.n2));
            }
        }

        LocalSum localSum = new LocalSum(n1, n2);
        localSum.displaySum();

    }

    public void testAnonymousClass () {

        new Object() {
            public void doSomething () {
                System.out.println("Method called from anonymous class");
            }
        }.doSomething();


    }

    public Outer() {
        System.out.println("public Outer constructor");
        Inner inner = new Inner();
        Immersed immersed = new Immersed();
    }

    public Outer(int n1, int n2) {
        System.out.println("Testing local class");
        testLocalClass(n1, n2);
    }

    public Outer(boolean callAnonymous) {
        if (callAnonymous) testAnonymousClass();
    }

}
