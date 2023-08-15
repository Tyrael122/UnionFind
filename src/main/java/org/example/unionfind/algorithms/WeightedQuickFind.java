package org.example.unionfind.algorithms;

import org.example.interfaces.UnionFindAlgorithm;

import java.util.Arrays;

public class WeightedQuickFind implements UnionFindAlgorithm {
    private final int[] values;
    private final int[] sizes;

    public WeightedQuickFind(int n) {
        this.values = initializeValues(n);
        this.sizes = initializeSizes(n);
    }

    @Override
    public void union(int a, int b) {
        if (sizes[a] < sizes[b]) {
            makeFirstParentOfSecond(b, a);
        } else {
            makeFirstParentOfSecond(a, b);
        }
    }

    private void makeFirstParentOfSecond(int a, int b) {
        int rootA = getRoot(a);
        int rootB = getRoot(b);
        setRoot(rootB, rootA);

        sizes[rootA] = sizes[rootA] + sizes[rootB];
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

    private int[] initializeSizes(int n) {
        int[] sizes = new int[n];
        Arrays.fill(sizes, 1);

        return sizes;
    }
}
