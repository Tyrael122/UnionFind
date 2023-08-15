package org.example.unionfind.algorithms;

import org.example.interfaces.UnionFindAlgorithm;

public class QuickFind implements UnionFindAlgorithm {
    private final int[] values;

    public QuickFind(int n) {
        this.values = initializeValues(n);
    }

    @Override
    public void union(int a, int b) {
        if (a == b) {
            return;
        }

        setRoot(b, getRoot(a));
    }

    @Override
    public boolean isConnected(int a, int b) {
        return getRoot(a) == getRoot(b);
    }

    private void setRoot(int a, int newRoot) {
        int oldRoot = getRoot(a);
        values[oldRoot] = newRoot;
    }

    private int getRoot(int a) {
        int parent = values[a];
        if (parent == a) {
            return a;
        }

        return getRoot(parent);
    }

    private int[] initializeValues(int n) {
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i;
        }

        return values;
    }
}
