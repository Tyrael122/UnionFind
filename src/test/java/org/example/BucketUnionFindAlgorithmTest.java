package org.example;

import org.example.unionfind.algorithms.bucket.BucketUnionFindAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketUnionFindAlgorithmTest {

    @Test
    void union() {
        BucketUnionFindAlgorithm bucketUnionFind = new BucketUnionFindAlgorithm(10);

        bucketUnionFind.union(1, 2);
        assertTrue(bucketUnionFind.isConnected(1, 2));
    }

    @Test
    void connectedReflexiveProperty() {
        BucketUnionFindAlgorithm bucketUnionFind = new BucketUnionFindAlgorithm(10);

        assertTrue(bucketUnionFind.isConnected(1, 1));
    }

    @Test
    void connectedSymmetricProperty() {
        BucketUnionFindAlgorithm bucketUnionFind = new BucketUnionFindAlgorithm(10);

        bucketUnionFind.union(1, 2);
        assertTrue(bucketUnionFind.isConnected(2, 1));
    }

    @Test
    void connectedTransitiveProperty() {
        BucketUnionFindAlgorithm bucketUnionFind = new BucketUnionFindAlgorithm(10);

        bucketUnionFind.union(1, 2);
        bucketUnionFind.union(2, 8);
        assertTrue(bucketUnionFind.isConnected(1, 8));
    }

    @Test
    void connected() {
        BucketUnionFindAlgorithm bucketUnionFind = new BucketUnionFindAlgorithm(10);

        bucketUnionFind.union(1, 2);
        bucketUnionFind.union(8, 9);

        bucketUnionFind.union(1, 8);
        assertTrue(bucketUnionFind.isConnected(1, 9));
    }
}