package gui.GUI2_1;

import gui.GUI2_1.model.Flecista;
import gui.GUI2_1.model.Singer;
import gui.GUI2_1.model.Skrzypek;
import gui.GUI2_1.model.Wiolonczelista;

public class Main {

    public static void main(String[] args) {

        Singer[] singers = {
                new Skrzypek("Aleks", 2),
                new Wiolonczelista("Bartek", 1),
                new Flecista("Czarek", 0.5)
        };

        for (Singer s: singers) {
            System.out.println(s);
        }

        Singer theBest = Singer.maxHonorarium(singers);
        System.out.println("The best: ");
        System.out.println(theBest);
    }

}
