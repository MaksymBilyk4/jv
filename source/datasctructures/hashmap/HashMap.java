package datasctructures.hashmap;

import datasctructures.list.List;


public class HashMap<K, V> {

    private final static int INITIAL_CAPACITY = 5;

    private final static double LOAD_FACTOR = 0.75;

    private int elementCount;
    private int currentCapacity;

    private BucketItem[] buckets;


    @SuppressWarnings("unchecked")
    public HashMap() {
        this.buckets = new BucketItem[INITIAL_CAPACITY];
        this.elementCount = 0;
        this.currentCapacity = INITIAL_CAPACITY;
    }

    public K put(K key, V value) {

        if (((double) this.elementCount + 1) / this.buckets.length >= LOAD_FACTOR) {
            rehash();
        }

        int keyHash = key.hashCode();
        int bucketIndex = calculateBucketIndex(keyHash);

        EntryNode<K, V> entryNode = new EntryNode<>(key, value);

        if (this.buckets[bucketIndex] == null) {
            this.buckets[bucketIndex] = entryNode;
            this.elementCount++;
            return key;
        } else {
            if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.LIST) {
                List<EntryNode<K, V>> nodeList = (List<EntryNode<K, V>>) this.buckets[bucketIndex];

                for (EntryNode<K, V> entry : nodeList) {
                    if (entry.getKey().hashCode() == keyHash && entry.getKey().equals(key)) {
                        entry.setValue(value);
                        return entry.getKey();
                    }
                }

                // if upper condition didn't complete, then we didn't find element with the same value, but we still have collision
                EntryNode<K, V> newEntry = new EntryNode<>(key, value);
                nodeList.addFirst(newEntry);
                this.elementCount++;
                return entryNode.getKey();

            } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.ENTRY_NODE) {
                EntryNode<K, V> node = (EntryNode<K, V>) this.buckets[bucketIndex];

                if (node.getKey().hashCode() == keyHash && node.getKey().equals(key)) {
                    node.setValue(value);
                    return node.getKey();
                } else {
                    List<EntryNode<K, V>> nodeList = new List<>();
//                    if (node.getKey().hashCode() == keyHash && !node.getKey().equals(key)) {
                    nodeList.addFirst(node);
                    EntryNode<K, V> newEntryNode = new EntryNode<>(key, value);
                    nodeList.addFirst(newEntryNode);
                    this.buckets[bucketIndex] = nodeList;
                    this.elementCount++;
                    return entryNode.getKey();
//                    } else if (node.getKey().hashCode() != keyHash) {

//                    }
                }
            }
        }

        return null;

    }

    public V get(K key) {

        int keyHash = key.hashCode();
        int bucketIndex = calculateBucketIndex(keyHash);

        if (this.buckets[bucketIndex] == null) {
            return null;
        } else {

            if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.LIST) {
                List<EntryNode<K, V>> entryNodeList = (List<EntryNode<K, V>>) this.buckets[bucketIndex];

                for (EntryNode<K, V> entry : entryNodeList) {
                    if (entry.getKey().hashCode() == keyHash && entry.getKey().equals(key)) {
                        return entry.getValue();
                    }
                }

                return null;

            } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.ENTRY_NODE) {
                EntryNode<K, V> foundNode = (EntryNode<K, V>) this.buckets[bucketIndex];
                if (foundNode.getKey().hashCode() == keyHash && foundNode.getKey().equals(key)) {
                    return foundNode.getValue();
                } else {
                    return null;
                }
            }

        }

        return null;
    }

    public V remove(K key) {

        int bucketIndex = calculateBucketIndex(key.hashCode());

        if (this.buckets[bucketIndex] == null) {
            return null;
        } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.ENTRY_NODE) {
            EntryNode<K, V> node = (EntryNode<K, V>) this.buckets[bucketIndex];

            if (node.getKey().hashCode() == key.hashCode() && node.getKey().equals(key)) {
                this.buckets[bucketIndex] = null;
                this.elementCount--;
                return node.getValue();
            }

        } else if (this.buckets[bucketIndex].getBucketInstance() == BucketInstance.LIST) {
            List<EntryNode<K, V>> nodeList = (List<EntryNode<K,V>>) this.buckets[bucketIndex];
            V returnValue = null;
            for (EntryNode<K, V> entry : nodeList) {
                if (entry.getKey().hashCode() == key.hashCode() && entry.getKey().equals(key)) {
                    nodeList.remove(entry);
                    this.elementCount--;
                    returnValue = entry.getValue();
                    break;
                }
            }

            if (nodeList.size() == 0) this.buckets[bucketIndex] = null;

            return returnValue;


        }

        return null;

    }

    public void clear() {
        this.buckets = new BucketItem[INITIAL_CAPACITY];
        this.elementCount = 0;
    }

    public boolean contains(K key) {
        int keyHash = key.hashCode();
        int bucketIndex = calculateBucketIndex(keyHash);

        BucketItem bucketItem = this.buckets[bucketIndex];

        if (bucketItem == null) {
            return false;
        } else {
            if (bucketItem.getBucketInstance() == BucketInstance.LIST) {
                List<EntryNode<K, V>> nodeList = (List<EntryNode<K, V>>) bucketItem;
                for (EntryNode<K, V> node : nodeList) {
                    if (node.getKey().hashCode() == keyHash && node.getKey().equals(key)) {
                        return true;
                    }
                }
                return false;
            } else if (bucketItem.getBucketInstance() == BucketInstance.ENTRY_NODE) {
                EntryNode<K, V> node = (EntryNode<K, V>) bucketItem;
                return node.getKey().hashCode() == keyHash && node.getKey().equals(key);
            }
        }

        return false;

    }

    public int size() {
        return this.elementCount;
    }

    public boolean isEmpty() {
        return this.elementCount == 0;
    }

    public void displayMap() {
        for (BucketItem item : this.buckets) {
            if (item != null) {
                if (item.getBucketInstance() == BucketInstance.LIST) {
                    for (EntryNode<K, V> node : (List<EntryNode<K, V>>) item) {
                        System.out.println(node);
                    }
                } else if (item.getBucketInstance() == BucketInstance.ENTRY_NODE) {
                    System.out.println(item);
                }
            }
        }
    }

    public BucketItem[] getBuckets() {
        return this.buckets;
    }

    // ===============================================================================================================
    private void rehash() {
        this.currentCapacity = this.currentCapacity * 2;
        BucketItem[] extendedBuckets = new BucketItem[this.currentCapacity];

        for (BucketItem bucketItem : this.buckets) {

            if (bucketItem != null) {
                if (bucketItem.getBucketInstance() == BucketInstance.ENTRY_NODE) {
                    EntryNode<K, V> node = (EntryNode<K, V>) bucketItem;
                    int bucketIndex = calculateBucketIndex(node.getKey().hashCode());
                    validateBucket(extendedBuckets, bucketIndex, node);
                } else if (bucketItem.getBucketInstance() == BucketInstance.LIST) {
                    for (EntryNode<K, V> node : (List<EntryNode<K, V>>) bucketItem) {
                        int bucketIndex = calculateBucketIndex(node.getKey().hashCode());
                        validateBucket(extendedBuckets, bucketIndex, node);
                    }
                }
            }
        }

        this.buckets = extendedBuckets;
    }

    private void validateBucket(BucketItem[] buckets, int bucketIndex, EntryNode<K, V> node) {
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = node;
        } else if (buckets[bucketIndex].getBucketInstance() == BucketInstance.ENTRY_NODE) {
            List<EntryNode<K, V>> entryNodes = new List<>();
            entryNodes.addFirst((EntryNode<K, V>) buckets[bucketIndex]);
            entryNodes.addFirst(node);
            buckets[bucketIndex] = entryNodes;
        } else if (buckets[bucketIndex].getBucketInstance() == BucketInstance.LIST) {
            List<EntryNode<K, V>> entryNodes = (List<EntryNode<K, V>>) buckets[bucketIndex];
            entryNodes.addFirst(node);
        }
    }

    private int calculateBucketIndex(int hashCode) {
        return Math.abs(hashCode % this.currentCapacity);
    }

}
