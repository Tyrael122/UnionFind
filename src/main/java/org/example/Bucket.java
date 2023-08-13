package org.example;

import java.util.HashSet;
import java.util.Set;

public class Bucket {
    private final Set<Integer> indexes = new HashSet<>();
    private Bucket reference;

    public void add(int index) {
        indexes.add(index);
    }

    public void mergeWithBucket(Bucket bucket) {
        indexes.addAll(bucket.indexes);
    }

    public Set<Integer> getIndexes() {
        if (reference != null) {
            return reference.getIndexes();
        }

        return indexes;
    }

    public Bucket getReference() {
        return reference;
    }

    public void setReference(Bucket bucket) {
        this.reference = bucket;
    }
}
