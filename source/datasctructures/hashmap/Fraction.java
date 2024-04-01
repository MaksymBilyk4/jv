package datasctructures.hashmap;

public final class Fraction {

    private int nominator;

    private int denominator;

    public Fraction(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        int max = Math.max(String.valueOf(this.nominator).length(), String.valueOf(this.denominator).length());
        String lines = "-".repeat(max);

        return this.nominator + "\n" + lines + "\n" + this.denominator;
    }


    public int getNominator() {
        return nominator;
    }

    public void setNominator(int nominator) {
        this.nominator = nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}
