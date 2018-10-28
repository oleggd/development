package com.dolgov.datastructures.map;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMap<K,V> implements Map<K,V>, Iterable {

    private final static double LOAD_FACTOR = 0.75;
    private final static int INCREASE_FACTOR = 2;
    private final static int INITIAL_CAPACITY = 3;

    ArrayList<Entry>[] buckets = new ArrayList[INITIAL_CAPACITY];
    int size;


    private int getBucketIndex(K key, int bucketsSize) {

        return Math.abs(key.hashCode() % bucketsSize);
    }

    @Override
    public V put(K key, V value) {

        extendBuckets();

        int index = getBucketIndex(key, buckets.length);
        // create new bucket if
        if ( buckets[index] == null ) {
            buckets[index] = new ArrayList<>();
        }

        ArrayList bucket = buckets[index];

        V originalValue = null;
        // find existing entry
        for (Object entryObject : bucket) {
            Entry entry = (Entry) entryObject;

            if( entry.key.equals(key) ){
                originalValue = entry.value;
                entry.value   = value;
                return originalValue;
            }
        }

        // add new entry
        if (originalValue == null ) {

            bucket.add(new Entry(key,value));
            buckets[index] = bucket;
        }
        // add
        size++;
        return originalValue;
    }

    private void extendBuckets() {
        // check size of buckets and extend if no space left
        if (size > buckets.length * LOAD_FACTOR) {

            ArrayList<Entry>[] tempBuckets = new ArrayList[buckets.length * INCREASE_FACTOR];

            // reallocate entries
            int index = 0;
            for (ArrayList bucket : buckets) {
                //ArrayList newBucket = new Entry[];
                if (bucket != null) {
                    for (Object entryObject : bucket) {
                        if (entryObject != null) {
                            Entry entry = (Entry) entryObject;
                            index = getBucketIndex(entry.key, tempBuckets.length);

                            //newBucket.add(entry);
                            tempBuckets[index] = bucket;
                        }
                    }
                }
            }
            buckets = tempBuckets;
        }
    }


    @Override
    public V putIfAbsent(K key, V value) {
        int index = getBucketIndex(key, buckets.length);

        // check size of buckets and extend if no space left
        extendBuckets();
        // create new bucket if
        if ( buckets[index] == null ) {
            buckets[index] = new ArrayList<>();
        }

        ArrayList bucket = buckets[index];

        V originalValue = null;
        // find existing entry
        for (Object entryObject : bucket) {
            Entry entry = (Entry) entryObject;

            if( entry.key.equals(key) ){
                originalValue = entry.value;
                //entry.value   = value;
                return originalValue;
            }
        }

        // add new entry
        if (originalValue == null ) {

            bucket.add(new Entry(key,value));
            buckets[index] = bucket;
        }
        // add
        size++;
        return originalValue;
    }

    @Override
    public V get(K key) {

        int index = getBucketIndex(key, buckets.length);

        ArrayList bucket = buckets[index];
        if (bucket == null) {
            return null;
        }

        for (Object bucketEntry : bucket) {
            Entry entry = (Entry) bucketEntry;
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {

        int index = getBucketIndex(key, buckets.length);
        ArrayList bucket = buckets[index];

        if (bucket == null) {
            return null;
        }

        V oldValue = null;

        Iterator iterator = bucket.iterator();
        // remove
        while (iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();

            if (entry.key.equals(key)) {
                oldValue = entry.value;
                iterator.remove();
                break;
            }
        }

        size--;
        return oldValue;

    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {

        private int index;
        private Iterator iterator = buckets[index].iterator();

        @Override
        public boolean hasNext() {
            boolean result = iterator.hasNext();
            if (!result && index + 1 < buckets.length) {
                result = buckets[index + 1].iterator().hasNext();
            }
            return result;
        }

        @Override
        public V next() {

            Object item = null;
            if (iterator.hasNext()) {
                item = iterator.next();
            } else if (!iterator.hasNext() && index + 1 < buckets.length) {
                index++;
                iterator = buckets[index].iterator();
                if (iterator.hasNext()) {
                    item = iterator.next();
                }
            }
            return ((Entry) item).value;
        }
    }
    private class Entry {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
