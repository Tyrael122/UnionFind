package org.example;

import java.util.Set;
import java.util.stream.IntStream;

public class UnionFindFormatter {
    private final UnionFind unionFind;
    private final Set<Integer>[] buckets;

    public UnionFindFormatter(UnionFind unionFind) {
        this.unionFind = unionFind;
        this.buckets = unionFind.getBuckets();
    }

    public String getFormattedBuckets() {
        return "[" + getBucketsAsString() + "]";
    }

    private String getBucketsAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < unionFind.getCapacity(); i++) {
            if (isAlreadyPrinted(i)) {
                stringBuilder.append(getAlreadyPrintedReference(i));
                stringBuilder.append(getComma(i));
                continue;
            }

            stringBuilder.append(buckets[i].toString());
            stringBuilder.append(getComma(i));
        }
        return stringBuilder.toString();
    }

    private boolean isAlreadyPrinted(int index) {
        if (buckets[index].isEmpty()) {
            return false;
        }

        return IntStream.range(0, index).anyMatch(i -> buckets[i].equals(buckets[index]));
    }

    private String getAlreadyPrintedReference(int index) {
        for (int i = 0; i < index; i++) {
            if (buckets[i].equals(buckets[index])) {
                return "ref(" + i + ")";
            }
        }

        return "";
    }

    private String getComma(int i) {
        if (i != unionFind.getCapacity() - 1) {
            return ", ";
        }

        return "";
    }
}
