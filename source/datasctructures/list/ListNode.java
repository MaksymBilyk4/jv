package datasctructures.list;

import java.util.Objects;

public class ListNode<E> {

    private E element;

    private ListNode<E> next;

    public ListNode(E element) {
        this.element = element;
        this.next = null;
    }

    public ListNode(E element, ListNode<E> next) {
        this.element = element;
        this.next = next;
    }

    // GETTERS & SETTERS

    public boolean hasNext() {
        return !(this.next == null);
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(element, listNode.element) && Objects.equals(next, listNode.next);
    }
}
