package org.example;

public class UnionFind {
    private final Bucket[] buckets;

    public UnionFind(int n) {
        buckets = initializeBuckets(n);
    }

    public void union(int a, int b) {
        validateIndexes(a, b);

        if (a == b) {
            return;
        }

        if (isConnected(a, b)) {
            return;
        }

        int lowestIndex = Math.min(a, b);
        int highestIndex = Math.max(a, b);

        Bucket referenceToBucket = buckets[lowestIndex];
        referenceToBucket.add(lowestIndex);
        referenceToBucket.add(highestIndex);

        referenceToBucket.mergeWith(buckets[highestIndex]);
        buckets[highestIndex].setReference(referenceToBucket);
    }

    public boolean isConnected(int a, int b) {
        validateIndexes(a, b);

        if (a == b) {
            return true;
        }

        int lowestIndex = Math.min(a, b);
        int highestIndex = Math.max(a, b);

        return buckets[lowestIndex].contains(highestIndex);
    }

    private void validateIndexes(int a, int b) {
        if (a > buckets.length || b > buckets.length) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    private Bucket[] initializeBuckets(int n) {
        Bucket[] buckets = new Bucket[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new Bucket();
        }

        return buckets;
    }

    public Bucket[] getBuckets() {
        return buckets;
    }
}
