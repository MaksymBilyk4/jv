package gui.GUI2_2.model;

public abstract class Singer {

    private static int counter = 0;

    private String name;
    private int uniqueNumber;



    public Singer(String name) {
        counter++;
        this.uniqueNumber = counter;
        this.name = name;
    }


    public static Singer mostLouder(Singer[] singers) {

        if (singers.length == 1) return singers[0];

        StringBuilder song;
        Singer mostLouderSinger = null;

        char maxChar = 0;
        char maxDigit = 0;

        int prevSum = 0;
        int currentSum = 0;

        for (int i = 0; i < singers.length; i++) {
            prevSum = currentSum;
            song = new StringBuilder(singers[i].sing());

            for (int j = 0; j < song.length(); j++) {
                if ((song.charAt(j) >= '1' && song.charAt(j) <= '9') && song.charAt(j) > maxDigit) maxDigit = song.charAt(j);

                if (
                        ((song.charAt(j) >= 'A' && song.charAt(j) <= 'Z') ||  (song.charAt(j) >= 'a' && song.charAt(j) <= 'z')) &&
                                song.charAt(j) >  maxChar
                ) maxChar = song.charAt(j);

                currentSum = maxChar + maxDigit;
            }

            if (currentSum > prevSum) {
                mostLouderSinger = singers[i];
            }
        }

        return mostLouderSinger;
    }

    public abstract String sing();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(int uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    @Override
    public String toString() {
        return "( " + this.uniqueNumber + " ) " + this.name + ": " + sing();
    }
}
