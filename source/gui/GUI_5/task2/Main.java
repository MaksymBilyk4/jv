package gui.GUI_5.task2;

public class Main {

    public static void main(String[] args) {

        IterNap text = new IterNap("prOgrAmoWanIe ObiEktOwe i Gui");

        for (char z: text)
            System.out.print(z + " ");

        System.out.println();

        text.setIterationStart(2);
        text.setIterationStep(3);

        for (char z: text)
            System.out.print(z + " ");

        System.out.println();

        text.setIterationStart(2);
        text.setIterationStep(3);

        text.forEach((Character ch) -> System.out.print(ch.toString().toLowerCase() + " "));

        text.setIterationStart(0);
        text.setIterationStep(1);
        System.out.println();
        text.forEach((Character ch) -> {
            if (ch >= 65 && ch <= 90) System.out.print(ch.toString().toLowerCase() + " ");
        });

    }

}
