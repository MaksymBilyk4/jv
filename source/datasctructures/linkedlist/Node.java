package datasctructures.linkedlist;

public class Node<V> {

    private Node<V> prev;

    private Node<V> next;

    private V value;

    // Only node's value constructor
    public Node (V value) {
        this.prev = null;
        this.next = null;
        this.value = value;
    }

    // node's value and PREV node
    public Node(V value, Node<V> prev) {
        this.prev = prev;
        this.next = null;
        this.value = value;
    }

    // node's value and NEXT node
    public Node(Node<V> next, V value) {
        this.prev = null;
        this.next = next;
        this.value = value;
    }

    // Full constructor: prev node, next node, node's value
    public Node(Node<V> prev, Node<V> next, V value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public Node<V> getPrev() {
        return prev;
    }

    public void setPrev(Node<V> prev) {
        this.prev = prev;
    }

    public Node<V> getNext() {
        return next;
    }

    public void setNext(Node<V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }


}
