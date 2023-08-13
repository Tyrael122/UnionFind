package org.example;

import java.util.*;

public class UnionFind {
    private final Set<Integer>[] buckets; // TODO: Make the component a class.
    private final int capacity;

    public UnionFind(int n) {
        buckets = initializeBuckets(n);

        this.capacity = n;
    }

    private Set<Integer>[] initializeBuckets(int n) {
        Set<Integer>[] buckets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new HashSet<>();
        }
        return buckets;
    }

    public void union(int a, int b) {
        validateIndexes(a, b);

        if (a == b) {
            return;
        }

        if (connected(a, b)) {
            return;
        }

        int lowestIndex = Math.min(a, b);
        int highestIndex = Math.max(a, b);

        Set<Integer> referenceToBucket = buckets[lowestIndex];
        referenceToBucket.add(lowestIndex);
        referenceToBucket.add(highestIndex);

        mergeWithBucket(highestIndex, referenceToBucket);
        setBucketsToPointToReference(buckets[highestIndex], referenceToBucket);

        buckets[highestIndex] = referenceToBucket;
    }

    private void mergeWithBucket(int highestIndex, Set<Integer> referenceToBucket) {
        referenceToBucket.addAll(buckets[highestIndex]);
    }

    private void setBucketsToPointToReference(Set<Integer> bucketToUpdate, Set<Integer> bucketReference) {
        for (int i : bucketToUpdate) {
            buckets[i] = bucketReference;
        }
    }

    public boolean connected(int a, int b) {
        validateIndexes(a, b);

        if (a == b) {
            return true;
        }

        int lowestIndex = Math.min(a, b);
        int highestIndex = Math.max(a, b);

        return buckets[lowestIndex].contains(highestIndex);
    }

    private void validateIndexes(int a, int b) {
        if (a > capacity || b > capacity) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    public Set<Integer>[] getBuckets() {
        return buckets;
    }

    public int getCapacity() {
        return capacity;
    }
}
