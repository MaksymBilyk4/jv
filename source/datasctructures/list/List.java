package datasctructures.list;


import datasctructures.hashmap.BucketInstance;
import datasctructures.hashmap.BucketItem;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

// basic operations only
public class List<E> implements BucketItem, Iterable<E> {

    private ListNode<E> head;

    private ListNode<E> tail;

    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(E element) {
        if (this.size == 0) {
            ListNode<E> node = new ListNode<>(element);
            this.head = node;
            this.tail = node;

            this.size++;
            return;
        }
        if (this.size == 1) {
            this.tail = this.head;
            ListNode<E> node = new ListNode<>(element);
            node.setNext(this.tail);
            this.head = node;
            this.size++;
            return;
        }

        ListNode<E> node = new ListNode<>(element);
        node.setNext(this.head);
        this.head = node;

        this.size++;
    }

    public void addLast(E element) {
        if (this.size == 0) {
            ListNode<E> node = new ListNode<>(element);
            this.head = node;
            this.tail = node;
            this.size++;
            return;
        }
        if (this.size == 1) {
            this.tail = new ListNode<>(element);
            this.head.setNext(this.tail);
            this.size++;
            return;
        }

        ListNode<E> node = new ListNode<>(element);
        this.tail.setNext(node);
        this.tail = this.tail.getNext();
        this.size++;
    }

    public boolean remove(E element) {
        if (this.head == null) return false;

        if (this.size == 1 && Objects.equals(element, this.head.getElement()) && Objects.equals(element, this.head.getElement())) {
            this.head = null;
            this.tail = null;
            this.size--;
            return true;
        }

        if (Objects.equals(element, this.head.getElement())) {
            this.head = this.head.getNext();
            this.size--;
            return true;
        }

        boolean deleted = false;
        ListNode<E> prevNode = this.head;
        ListNode<E> currentNode = this.head.getNext();

        while (currentNode != null) {
            if (Objects.equals(element, currentNode.getElement())) {

                if (Objects.equals(element, this.tail.getElement())) {
                    this.tail = prevNode;
                    prevNode.setNext(null);
                    this.size--;
                    deleted = true;
                    break;
                }

                prevNode.setNext(currentNode.getNext());
                deleted = true;
                this.size--;
                break;
            } else {
                prevNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }

        return deleted;
    }


    // not just remove, because of what to do when E type is Integer
    public boolean removeByIndex(int index) {
        if (index < 0 || index >= this.size) throw new IllegalArgumentException("Invalid index.");

        if (index == 0 && this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return true;
        }

        if (index == 0) {
            this.head = this.head.getNext();
            this.size--;
            return true;
        }

        ListNode<E> prevNode = this.head;
        ListNode<E> currentNode = this.head.getNext();

        boolean deleted = false;
        for (int i = 1; i < this.size; i++) {
            if (i == index) {

                if (Objects.equals(currentNode, this.tail)) {
                    this.tail = prevNode;
                    prevNode.setNext(null);
                    this.size--;
                    deleted = true;
                    break;
                }

                prevNode.setNext(currentNode.getNext());
                deleted = true;
                this.size--;
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        return deleted;
    }

    public E get(int index) {
        if (index < 0 || index >= this.size) throw new IllegalArgumentException("Invalid index.");

        if (index == this.size - 1) return this.tail.getElement();

        ListNode<E> currenNode = this.head;

        for (int i = 0; i < this.size; i++) {
            if (i == index) break;
            currenNode = currenNode.getNext();
        }

        return currenNode.getElement();
    }

    public int indexOf(E element) {
        int index = -1;

        if (this.size == 0) return index;

        ListNode<E> currentNode = this.head;
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(element, currentNode.getElement())) {
                index = i;
                break;
            }
            currentNode = currentNode.getNext();
        }

        return index;
    }

    public int lastIndexOf(E element) {
        int index = -1;

        ListNode<E> currentNode = this.head;
        int currentIndex = 0;

        while (currentNode != null) {
            if (Objects.equals(element, currentNode.getElement())) {
                index = currentIndex;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return index;

    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode<E> currentNode = this.head;

        while (currentNode != null) {
            sb.append(currentNode.getElement());
            if (currentNode.getNext() != null) sb.append(", ");
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public void displayList() {
        System.out.println(this);
    }

    public void displayInfo() {
        System.out.println("Head -> " + (this.head != null ? this.head.getElement() : "null") + ". Tail -> " + (this.tail != null ? this.tail.getElement() : "null") + ". Size -> " + this.size);
    }

    // GETTERS & SETTERS ====================================================================================

    public ListNode<E> getHead() {
        return this.head;
    }

    public void setHead(ListNode<E> head) {
        this.head = head;
    }

    public ListNode<E> getTail() {
        return this.tail;
    }

    public void setTail(ListNode<E> tail) {
        this.tail = tail;
    }



    @Override
    public BucketInstance getBucketInstance() {
        return BucketInstance.LIST;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private ListNode<E> currentNode = head;

            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = currentNode.getElement();
                currentNode = currentNode.getNext();
                return element;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not supported.");
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }
}
