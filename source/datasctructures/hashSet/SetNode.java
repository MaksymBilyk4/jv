package datasctructures.hashSet;

import datasctructures.hashmap.BucketInstance;
import datasctructures.hashmap.BucketItem;


public class SetNode<E> implements BucketItem {

    private E element;

    public SetNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.toString();
    }

    @Override
    public BucketInstance getBucketInstance() {
        return BucketInstance.SET_NODE;
    }
}
