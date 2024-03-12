package gui.GUI1;

import gui.GUI1.exception.IncorrectProstokatException;
import gui.GUI1.model.Prostokat;
import gui.GUI1.model.ProstokatZnakowy;

public class GUI_ONE {

    public static void main(String[] args) {

        Prostokat prostokaty[] = {
                new Prostokat(2, 3),
                new Prostokat(0, 3),
                new ProstokatZnakowy(4, 'a', 'e'),        // konstruktor z 3 parametrami
                new ProstokatZnakowy(5, 3, '*', '+'),    // konstruktor z 4 parametrami
                new ProstokatZnakowy(1, 2, 'a', 'a'),
                new ProstokatZnakowy(3, 3, '+', 'x'),
                new ProstokatZnakowy(1, 2, 'x', 'y'),
                new ProstokatZnakowy(3, 4, '^', '$')
        };

        for (int i = 0; i < prostokaty.length; i++) {
            try {
                System.out.println("Prostokat #" + (i + 1));
                prostokaty[i].rysuj();
                System.out.println();
            } catch (IncorrectProstokatException exception) {
                System.out.println(exception.getMessage());
                System.out.println();
            }
        }

    }

}
