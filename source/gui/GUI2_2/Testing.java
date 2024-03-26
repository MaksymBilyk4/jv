package gui.GUI2_2;

import gui.GUI2_2.model.Singer;

import java.util.Arrays;

public class Testing {

    public static void main(String[] args) {

        Singer s1 = new Singer("Houston") {
            @Override
            public String sing() {
                return "aabbccdefgh";
            }
        };

        Singer s2 = new Singer("Carrey") {
            @Override
            public String sing() {
                return "xyzt123";
            }
        };

        Singer s3 = new Singer("Darrey") {
            @Override
            public String sing() {
                return "eeae";
            }
        };
        Singer s4 = new Singer("Darrey") {
            @Override
            public String sing() {
                return "bebe";
            }
        };
        Singer s5 = new Singer("Madonna") {
            @Override
            public String sing() {
                return "aAa";
            }
        };

        Singer[] s = {s3, s2, s5, s4, s1};
        System.out.println(Arrays.toString(s));
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
    }

}
