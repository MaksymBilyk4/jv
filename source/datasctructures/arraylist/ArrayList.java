package datasctructures.arraylist;

import java.util.Arrays;

public class ArrayList<E> {


    private static final int INITIAL_CAPACITY = 10;

    private int size;

    private int capacity;

    private E[] data;


    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.data = (E[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = INITIAL_CAPACITY;
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Invalid Capacity");

        this.data = (E[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public int size() {
        return this.size;
    }

    public void add(E element) {
        if (this.size == this.capacity) {
            this.grow();
        }
        this.data[this.size++] = element;
    }

    public void add(E element, int index) {
        checkIndex(index);

        if (this.size == this.capacity) this.grow();

        for (int i = this.size; i >= index; i--)
            this.data[i] = this.data[i - 1];


        this.data[index] = element;
        this.size++;
    }

    public E get(int index) {
        checkIndex(index);

        return this.data[index];
    }

    // remove last
    public E pop() {
        if (this.size == 0) throw new EmptyListException("Can't remove when list is empty");
        E element = this.data[this.size - 1];
        this.data[this.size - 1] = null;
        this.size--;
        return element;
    }

    public E remove(int index) {
        this.checkIndex(index);

        if (index == this.size - 1) return pop();


        E element = this.data[index];

        for (int i = index; i <= this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.size--;

        return element;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        this.data = (E[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public boolean contains(E element) {
        boolean contains = false;
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(element)) {
                contains = true;
                break;
            }
        }

        return contains;
    }

    public void set(int index, E element) {
        checkIndex(index);

        this.data[index] = element;
    }

    public int indexOf(E element) {
        int index = -1;

        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(element)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int lastIndexOf(E element) {
        int index = -1;

        for (int i = this.size - 1; i >= 0; i--) {
            if (this.data[i].equals(element)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public void displayList() {
        System.out.print("[");
        for (int i = 0; i < this.size; i++)
            System.out.print(this.data[i] + (i != this.size - 1 ? ", " : ""));

        System.out.println("]");
    }

    public void displayListWithCapacity() {
        System.out.println(Arrays.toString(this.data));
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        this.capacity = this.capacity * 2;
        E[] grown = (E[]) new Object[this.capacity];

        // System.arraycopy...
        for (int i = 0; i < this.data.length; i++) {
            grown[i] = this.data[i];
        }

        this.data = grown;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size) throw new IllegalArgumentException("Invalid index");
    }

}
