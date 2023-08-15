package org.example;

public interface UnionFind {
    void union(int a, int b);

    boolean isConnected(int a, int b);
}
