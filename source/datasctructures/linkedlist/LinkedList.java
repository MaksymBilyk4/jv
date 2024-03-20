package datasctructures.linkedlist;

public class LinkedList<V> {

    private Node<V> head;
    private Node<V> tail;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }


    private void isAccessable(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index " + index + "is out of yours list range");
        if (index >= this.size) throw new IndexOutOfBoundsException("Index " + index + " is out of yours list range");
    }

    private Node<V> findNodeByIndex(int index) {
        isAccessable(index);

        if (index == 0) return this.head;
        if (index == this.size - 1) return this.tail;

        int iterationStarter = index > this.size / 2 ? this.size - 1 : 0;

        Node<V> searchNode;
        if (iterationStarter == 0) {
            searchNode = this.head;
            for (; iterationStarter < this.size / 2; iterationStarter++) {
                if (iterationStarter == index) break;
                searchNode = searchNode.getNext();
            }
        } else {
            searchNode = this.tail;
            for (; iterationStarter > this.size / 2; iterationStarter--) {
                if (iterationStarter == index) break;
                searchNode = searchNode.getPrev();
            }
        }

        return searchNode;
    }


    public V find(V value) {
        Node<V> currentNode = this.head;

        if (this.head == null) return null;

        while (currentNode.getNext() != null) {
            if (currentNode.getValue().equals(value))
                break;
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue().equals(value) ? currentNode.getValue() : null;
    }

    public V get(int index) {
        return this.findNodeByIndex(index).getValue();
    }

    public boolean insert(int index, V value) {
        if (index > this.size) throw new IndexOutOfBoundsException("Index " + index + " is out of yours list range");

        if (index == 0) return this.addFirst(value);
        if (index == this.size - 1) return this.addLast(value);

        Node<V> newNode = new Node<>(value);
        Node<V> foundNode = this.findNodeByIndex(index);
        System.out.println("d" + foundNode);

        foundNode.getPrev().setNext(newNode);
        newNode.setPrev(foundNode.getPrev());

        foundNode.setPrev(newNode);
        newNode.setNext(foundNode);

        this.size++;

        return true;
    }

    public boolean addFirst(V value) {
        Node<V> node = new Node<>(value);
        this.size++;

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return true;
        }

        node.setNext(this.head);
        this.head = node;

        return true;

    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public V peek() {
        return this.tail != null ? this.tail.getValue() : null;
    }

    public V getFirst() {
        return this.head != null ? this.head.getValue() : null;
    }

    public boolean addLast(V value) {
        Node<V> node = new Node<>(value);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        }

        if (this.head == this.tail) {
            node.setPrev(this.head);
            node.setNext(null);

            this.head.setNext(node);
            this.tail = node;
        }

        if (this.head != this.tail) {
            node.setPrev(this.tail);
            this.tail.setNext(node);

            node.setNext(null);

            this.tail = node;
        }

        this.size++;

        return true;
    }

    public void removeFirst() {
        if (this.size == 0) throw new RuntimeException("Can't remove from empty list");

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        this.head = this.head.getNext();
        this.head.setPrev(null);
        this.size--;

    }

    public void removeLast() {
        if (this.size == 0) throw new RuntimeException("Can't remove from empty list");

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return;
        }

        this.tail = this.tail.getPrev();
        this.tail.setNext(null);
        this.size--;

    }

    public void remove(int index) {
        isAccessable(index);

        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == this.size - 1) {
            removeLast();
            return;
        }

        Node<V> foundNode = this.findNodeByIndex(index);

        // bug for index 1, not deleting ???
        if (index == 1) {
            this.head.setNext(foundNode.getNext());
            foundNode.getNext().setPrev(this.head);
            this.size--;
            return;
        }

        foundNode.getPrev().setNext(foundNode.getNext());
        foundNode.getNext().setPrev(foundNode.getPrev());
        this.size--;
    }


    public Node<V> getHead() {
        return head;
    }

    public Node<V> getTail() {
        return tail;
    }

    public int size() {
        return size;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }


    public void displayList() {
        Node<V> node = this.head;
        if (node == null) {
            System.out.println("[]");
            return;
        }

        System.out.print("[ ");
        while (node != null) {
            System.out.print(node + (node.getNext() != null ? " ⇆ " : ""));
            node = node.getNext();
        }
        System.out.println(" ]");
    }

}
