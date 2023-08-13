package org.example;

import java.util.Arrays;

public class UnionFindFormatter {
    private final UnionFind unionFind;
    private final Bucket[] buckets;

    public UnionFindFormatter(UnionFind unionFind) {
        this.unionFind = unionFind;
        this.buckets = unionFind.getBuckets();
    }

    public String getFormattedBuckets() {
        return "[" + getBucketsAsString() + "]";
    }

    private String getBucketsAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < unionFind.getBuckets().length; i++) {
            if (isAlreadyPrinted(i)) {
                stringBuilder.append(getAlreadyPrintedReference(i));
                stringBuilder.append(getComma(i));
                continue;
            }

            stringBuilder.append(getFormattedBucketIndexes(i));
            stringBuilder.append(getComma(i));
        }
        return stringBuilder.toString();
    }

    private boolean isAlreadyPrinted(int index) {
        if (buckets[index].isEmpty()) {
            return false;
        }

        for (int i = 0; i < index; i++) {
            if (buckets[index].getReference().equals(buckets[i])) {
                return true;
            }
        }
        return false;
    }

    private String getAlreadyPrintedReference(int index) {
        for (int i = 0; i < index; i++) {
            if (buckets[index].getReference().equals(buckets[i])) {
                return "ref(" + i + ")";
            }
        }

        return "";
    }

    private String getFormattedBucketIndexes(int i) {
        Bucket bucket = buckets[i];

        return Arrays.toString(bucket.getIndexes().toArray());
    }

    private String getComma(int i) {
        if (i != unionFind.getBuckets().length - 1) {
            return ", ";
        }

        return "";
    }
}
