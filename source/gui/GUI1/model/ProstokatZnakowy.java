package gui.GUI1.model;


import gui.GUI1.exception.IncorrectProstokatException;

public class ProstokatZnakowy extends Prostokat {

    private char internalChar;
    private char externalChar;

    protected int id;

    private static int prostakatId = 0;
    private static int kwadratId = 0;

    public ProstokatZnakowy(int width, int height, char internalChar, char externalChar) {
        super(width, height);

        this.internalChar = internalChar;
        this.externalChar = externalChar;

        if (width == height) initKwadratId();
        else initProstokatId();
    }

    // kwadrat znakowy
    public ProstokatZnakowy(int side, char internalChar, char externalChar) {
        super(side);

        this.internalChar = internalChar;
        this.externalChar = externalChar;

        initKwadratId();
    }

    @Override
    public void rysuj() throws IncorrectProstokatException {
        if (this.getWidth() == 1 && this.internalChar != this.externalChar) {
            super.rysuj();
            throw new IncorrectProstokatException("Błędny prostokąt!\n");
        } else {
            int internalCharCount = this.getWidth() * 2 + ((this.getHeight() - 2) * 2);
            int externalCharCount = this.getWidth() * this.getHeight() - internalCharCount;
            String type = this.getWidth() == this.getHeight() ? "Kwadrat" : "Prostokat";
            System.out.println(type + " ( " + this.getId() + " ) rozmiaru " + this.getWidth() + " x " + this.getHeight());
            if (this.internalChar == this.externalChar)
                System.out.println(this.internalChar + " ---> " + internalCharCount);
            else {
                System.out.println(this.internalChar + " ---> " + internalCharCount);
                System.out.println(this.externalChar + " ---> " + externalCharCount);
            }
            drawFigure();
        }
    }

    public void drawFigure() {

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                if (i == 0 || i == this.getHeight() - 1) {
                    System.out.print(this.internalChar + " ");
                } else {
                    if (j == 0 || j == this.getWidth() - 1) {
                        System.out.print(this.internalChar + " ");
                    } else {
                        System.out.print(this.externalChar + " ");
                    }
                }
            }
            System.out.println();
        }

    }

    public char getInternalChar() {
        return internalChar;
    }

    public void setInternalChar(char internalChar) {
        this.internalChar = internalChar;
    }

    public char getExternalChar() {
        return externalChar;
    }

    public void setExternalChar(char externalChar) {
        this.externalChar = externalChar;
    }

    public int getId() {
        return this.id;
    }

    private void initKwadratId() {
        kwadratId++;
        this.id = kwadratId;
    }

    private void initProstokatId() {
        prostakatId++;
        this.id = prostakatId;
    }
}
