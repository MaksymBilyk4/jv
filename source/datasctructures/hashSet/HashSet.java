package datasctructures.hashSet;

import datasctructures.hashmap.BucketInstance;
import datasctructures.hashmap.BucketItem;
import datasctructures.list.List;

import java.util.Objects;

public class HashSet<E> {

    private final static double LOAD_FACTOR = 0.75;

    private final static int INITIAL_CAPACITY = 10;

    private int currentCapacity;
    private int elementCount;

    private BucketItem[] buckets;


    public HashSet() {
        this.buckets = new BucketItem[INITIAL_CAPACITY];

        this.elementCount = 0;
        this.currentCapacity = INITIAL_CAPACITY;
    }

    public int size() {
        return this.elementCount;
    }

    public boolean add(E element) {

        if ((double) (this.elementCount) / this.currentCapacity >= LOAD_FACTOR) {
            rehash();
        }

        int bucketIndex = calculateBucketIndex(element.hashCode());

        if (this.buckets[bucketIndex] != null) {

            if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.SET_NODE) {
                SetNode<E> currentNode = (SetNode<E>) this.buckets[bucketIndex];

                if (currentNode.getElement().hashCode() == element.hashCode() && currentNode.getElement().equals(element)) {
                    return false;
                } else if (
                        (currentNode.getElement().hashCode() == element.hashCode() && !Objects.equals(currentNode.getElement(), element)) || currentNode.getElement().hashCode() != element.hashCode()
                ) {
                    List<SetNode<E>> list = new List<>();
                    list.addFirst(currentNode);
                    list.addFirst(new SetNode<>(element));
                    this.buckets[bucketIndex] = list;
                    this.elementCount++;
                    return true;
                }

            } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.LIST) {

                List<SetNode<E>> nodesList = (List<SetNode<E>>) this.buckets[bucketIndex];
                for (SetNode<E> node : nodesList) {
                    if (node.getElement().hashCode() == element.hashCode() && node.getElement().equals(element)) {
                        return false;
                    }
                }
                nodesList.addFirst(new SetNode<>(element));
                this.elementCount++;
                return true;
            }

        } else {
            SetNode<E> setNode = new SetNode<>(element);
            this.buckets[bucketIndex] = setNode;
            this.elementCount++;
            return true;
        }

        return false;
    }

    public void clear() {
        this.currentCapacity = INITIAL_CAPACITY;
        this.buckets = new BucketItem[INITIAL_CAPACITY];
        this.elementCount = 0;
    }

    public boolean contains(E element) {
        int bucketIndex = calculateBucketIndex(element.hashCode());

        if (this.buckets[bucketIndex] == null) {
            return false;
        } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.LIST) {
            List<SetNode<E>> listNode = (List<SetNode<E>>) this.buckets[bucketIndex];

            for (SetNode<E> node : listNode) {
                if (element.hashCode() == node.getElement().hashCode() && element.equals(node.getElement()))
                    return true;
            }

        } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.SET_NODE) {
            SetNode<E> node = (SetNode<E>) this.buckets[bucketIndex];
            return element.hashCode() == node.getElement().hashCode() && element.equals(node.getElement());
        }

        return false;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean remove(E element) {
        int elementHash = element.hashCode();
        int bucketIndex = calculateBucketIndex(elementHash);

        if (this.buckets[bucketIndex] == null) {
            return false;
        } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.SET_NODE) {
            SetNode<E> node = (SetNode<E>) this.buckets[bucketIndex];
            if (node.getElement().hashCode() == elementHash && node.getElement().equals(element)) {
                this.buckets[bucketIndex] = null;
                this.elementCount--;
                return true;
            }
        } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.LIST) {
            List<SetNode<E>> nodes = (List<SetNode<E>>) this.buckets[bucketIndex];
            for (SetNode<E> node : nodes) {
                if (node.getElement().hashCode() == elementHash && node.getElement().equals(element)) {
                    nodes.remove(node);
                    this.elementCount--;
                    if (nodes.size() == 0) this.buckets[bucketIndex] = null;
                    return true;
                }
            }
        }

        return false;
    }

    private int calculateBucketIndex(int hash) {
        return Math.abs(hash % this.currentCapacity);
    }

    private void rehash() {
        this.currentCapacity = this.currentCapacity * 2;
        BucketItem[] extendedBuckets = new BucketItem[this.currentCapacity];

        for (BucketItem bucket : this.buckets) {
            if (bucket != null) {
                if (bucket.getBucketInstance() == BucketInstance.SET_NODE) {
                    validateAndPutToBucket(extendedBuckets, (SetNode<E>) bucket);
                } else if (bucket.getBucketInstance() == BucketInstance.LIST) {
                    for (SetNode<E> node : (List<SetNode<E>>) bucket) {
                        validateAndPutToBucket(extendedBuckets, node);
                    }
                }
            }
        }

        this.buckets = extendedBuckets;
    }

    private void validateAndPutToBucket(BucketItem[] buckets, SetNode<E> node) {
        int newBucketIndex = calculateBucketIndex(node.getElement().hashCode());

        if (buckets[newBucketIndex] == null) {
            buckets[newBucketIndex] = node;
        } else if (buckets[newBucketIndex].getBucketInstance() == BucketInstance.SET_NODE) {
            List<SetNode<E>> nodes = new List<>();
            nodes.addFirst((SetNode<E>) buckets[newBucketIndex]);
            nodes.addFirst(node);
            buckets[newBucketIndex] = nodes;
        } else if (buckets[newBucketIndex].getBucketInstance() == BucketInstance.LIST) {
            List<SetNode<E>> nodes = (List<SetNode<E>>) buckets[newBucketIndex];
            nodes.addFirst(node);
        }
    }

    public BucketItem[] getBuckets() {
        return this.buckets;
    }

    public void displaySet() {
        System.out.print("{");
        for (BucketItem element : this.buckets) {
            if (element != null) {
                if (element.getBucketInstance() == BucketInstance.SET_NODE) {
                    System.out.print(element + ", ");
                } else if (element.getBucketInstance() == BucketInstance.LIST) {
                    for (SetNode<E> listNode : (List<SetNode<E>>) element) {
                        System.out.print(listNode + ", ");
                    }
                }
            }
        }
        System.out.println("}");
    }

}
