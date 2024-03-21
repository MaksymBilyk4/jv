package datasctructures.stack;

import java.util.EmptyStackException;

public class Stack<V> {

    private int capacity;

    private int elementCount;

    private V[] elements;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.capacity = capacity;
        this.elementCount = 0;
        this.elements = (V[]) new Object[this.capacity];
    }

    @SuppressWarnings("unchecked")
    public Stack() {
        this.capacity = 10;
        this.elementCount = 0;
        this.elements = (V[]) new Object[this.capacity];
    }


    public boolean empty() {
        return this.elementCount == 0;
    }

    public V peek() {
        if (this.empty()) throw new EmptyStackException();

        return this.elements[this.elementCount - 1];
    }

    @SuppressWarnings("unchecked")
    public V push(V el) {
        if (this.elementCount == this.capacity) {
            this.capacity += 10;
            V[] copy = (V[]) new Object[this.capacity];

            System.arraycopy(this.elements, 0, copy, 0, this.elements.length);

            copy[this.elementCount] = el;
            this.elements = copy;
            this.elementCount++;
        }

        this.elements[this.elementCount] = el;
        this.elementCount++;

        return el;
    }

    public V pop() {
        if (this.empty()) throw new EmptyStackException();

        V el = this.elements[this.elementCount - 1];

        this.elements[this.elementCount - 1] = null;
        this.elementCount--;

        return el;
    }

    public int search(V obj) {
        if (this.empty()) throw new EmptyStackException();

        int foundIndex = -1;

        if (obj == null) {
            for (int i = this.elementCount - 1; i >= 0; i--) {
                if (this.elements[i] == null) {
                    foundIndex = i;
                    break;
                }
            }
        } else {
            for (int i = this.elementCount - 1; i >= 0; i--) {
                if (obj.equals(this.elements[i])) {
                    foundIndex = i;
                    break;
                }
            }
        }

        return foundIndex;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        this.elementCount = 0;
        this.capacity = 10;
        this.elements = (V[]) new Object[this.capacity];
    }

    public void displayStack() {

        if (this.empty()) {
            System.out.println("[]");
            return;
        }

        System.out.print("[ ");
        for (int i = 0; i < this.elementCount; i++)
            System.out.print(this.elements[i] + (i != this.elementCount - 1 ? ", " : ""));

        System.out.println(" ]");

    }


    // TEST METHODS ===================================================================================================


    public int getCapacity() {
        return capacity;
    }

    public int getElementCount() {
        return elementCount;
    }

    public V[] getElements() {
        return elements;
    }


}
