package gui.GUI2_2;

import gui.GUI2_2.model.Singer;

public class Main {

    public static void main(String[] args) {

        Singer s1 = new Singer("Dietrich") {
            @Override
            public String sing() {
                return "oooooo6oooooo";
            }
        };

        Singer s2 = new Singer("Piaf") {
            @Override
            public String sing() {
                return "a4iBBiii";
            }
        };

        Singer s3 = new Singer("Adele") {
            @Override
            public String sing() {
                return "aAa";
            }
        };

        Singer sp[] = {s2, s1, s3};

        for (Singer s : sp)
            System.out.println(s);


        System.out.println();
        System.out.println(Singer.mostLouder(sp));
    }

}
