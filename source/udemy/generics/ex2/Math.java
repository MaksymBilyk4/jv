package udemy.generics.ex2;

public abstract class Math {

    protected String elementName;

    public Math(String elementName) {
        this.elementName = elementName;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "elementName='" + elementName + '\'' +
                '}';
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }
}
