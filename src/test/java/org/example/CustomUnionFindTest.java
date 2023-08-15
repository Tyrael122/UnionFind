package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomUnionFindTest {

    @Test
    void union() {
        CustomUnionFind customUnionFind = new CustomUnionFind(10);

        customUnionFind.union(1, 2);
        assertTrue(customUnionFind.isConnected(1, 2));
    }

    @Test
    void connectedReflexiveProperty() {
        CustomUnionFind customUnionFind = new CustomUnionFind(10);

        assertTrue(customUnionFind.isConnected(1, 1));
    }

    @Test
    void connectedSymmetricProperty() {
        CustomUnionFind customUnionFind = new CustomUnionFind(10);

        customUnionFind.union(1, 2);
        assertTrue(customUnionFind.isConnected(2, 1));
    }

    @Test
    void connectedTransitiveProperty() {
        CustomUnionFind customUnionFind = new CustomUnionFind(10);

        customUnionFind.union(1, 2);
        customUnionFind.union(2, 8);
        assertTrue(customUnionFind.isConnected(1, 8));
    }

    @Test
    void connected() {
        CustomUnionFind customUnionFind = new CustomUnionFind(10);

        customUnionFind.union(1, 2);
        customUnionFind.union(8, 9);

        customUnionFind.union(1, 8);
        assertTrue(customUnionFind.isConnected(1, 9));
    }
}