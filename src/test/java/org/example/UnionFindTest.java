package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {

    @Test
    void union() {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(1, 2);
        assertTrue(unionFind.connected(1, 2));
    }

    @Test
    void connectedReflexiveProperty() {
        UnionFind unionFind = new UnionFind(10);

        assertTrue(unionFind.connected(1, 1));
    }

    @Test
    void connectedSymmetricProperty() {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(1, 2);
        assertTrue(unionFind.connected(2, 1));
    }

    @Test
    void connectedTransitiveProperty() {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(1, 2);
        unionFind.union(2, 8);
        assertTrue(unionFind.connected(1, 8));
    }

    @Test
    void connected() {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(1, 2);
        unionFind.union(8, 9);

        unionFind.union(1, 8);
        assertTrue(unionFind.connected(1, 9));
    }
}