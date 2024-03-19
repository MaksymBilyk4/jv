package gui.GUI3.task4;

import gui.GUI3.task4.interfaces.Flyable;
import gui.GUI3.task4.interfaces.Speakable;
import gui.GUI3.task4.model.Bird;
import gui.GUI3.task4.model.Plain;
import gui.GUI3.task4.model.UFO;
import gui.GUI3.task4.model.Virus;

public class Main {

    public static void main(String[] args) {

        UFO ufo1 = new UFO("Black");
        UFO ufo2 = new UFO("White");
        Bird bird1 = new Bird("ABCDEF");
        Plain p1 = new Plain("test32010-4dasdf");
        Plain p2 = new Plain("boing21321");
        Virus v1 = new Virus("COVID-19");


        Flyable f1 = Flyable.hybrid(ufo1, ufo2);
        Flyable f2 = Flyable.hybrid(bird1, p1);
        Flyable f3 = Flyable.hybrid(p2, p1);
        Flyable f4 = Flyable.hybrid(p2, ufo1);
        Flyable f5 = Flyable.hybrid(ufo1, bird1);
        Flyable f6 = Flyable.hybrid(v1, v1);
        Flyable f7 = Flyable.hybrid(p1, v1);
        Flyable f8 = Flyable.hybrid(v1, bird1);
        Flyable f9 = Flyable.hybrid(ufo1, v1);

        Flyable[] flyables = new Flyable[]{f1, f2, f3, f4, f5, f6, f7, f8, f9};

        Speakable s1 = () -> "Bla bla bla bla bla bla";
        Speakable s2 = () -> "Java java java java";
        Speakable s3 = () -> "interface class extends int var let const pointer jvw compiler c++";
        Speakable s4 = () -> "random";
        Speakable s5 = () -> "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        Speakable[] speakables = new Speakable[]{s1, s2, s3, s4, s5};

        Speakable speakable = theLoudest(speakables);
        System.out.println("The loudest --> " + speakable.speak());

        Flyable flyable = theShortestDistance(flyables);
        System.out.println("The shortest distance flyable -> " + flyable.distance());

    }

    public static Flyable theShortestDistance(Flyable[] flyables) {
        if (flyables.length == 0) throw new IllegalArgumentException("Array should contain at least 1 element");
        if (flyables.length == 1) return flyables[0];

        Flyable flyable = flyables[0];

        for (Flyable f : flyables) {
            if (Double.parseDouble(f.distance()) < Double.parseDouble(flyable.distance()))
                flyable = f;
        }

        return flyable;
    }

    public static Speakable theLoudest(Speakable[] speakables) {
        if (speakables.length == 0) throw new IllegalArgumentException("Array should contain at least 1 element");
        if (speakables.length == 1) return speakables[0];

        Speakable theLoudest = speakables[0];

        for (Speakable s : speakables) {
            if (s.speak().length() > theLoudest.speak().length()) theLoudest = s;
        }

        return theLoudest;
    }


}
