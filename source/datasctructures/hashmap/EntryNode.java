package datasctructures.hashmap;

public class EntryNode<K, V> implements BucketItem {

    private K key;
    private V value;

    public EntryNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // GETTERS & SETTERS =============================================================================================
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{ " + this.key + " : " + this.value + " }";
    }

    @Override
    public BucketInstance getBucketInstance() {
        return BucketInstance.ENTRY_NODE;
    }
}
