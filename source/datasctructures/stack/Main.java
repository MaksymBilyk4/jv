package datasctructures.stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= 40; i++)
            stack.push(i);

        stack.displayStack();

        for (int i = 0; i <= 10; i++)
            System.out.println("Removed element ---> " + stack.pop());


        stack.displayStack();

        System.out.println("Is empty ---> " + stack.empty());

        System.out.println("Clear...");
        stack.clear();
        System.out.println("Is empty ---> " + stack.empty());
        stack.displayStack();


        stack.push(3);
        stack.push(6);
        stack.push(9);
        stack.push(11);
        stack.push(22);
        stack.push(18);
        stack.push(27);
        stack.push(null);
        stack.displayStack();

        System.out.println(stack.search(888));



    }

}
