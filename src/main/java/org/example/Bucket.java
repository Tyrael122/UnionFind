package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bucket {
    private final Set<Integer> indexes = new HashSet<>();
    private Bucket reference;

    public void add(int index) {
        if (reference != null) {
            reference.add(index);
            return;
        }

        indexes.add(index);
    }

    public void mergeWith(Bucket bucket) {
        if (reference != null) {
            reference.mergeWith(bucket);
            return;
        }

        indexes.addAll(bucket.getIndexes());
    }

    public boolean contains(int index) {
        if (reference != null) {
            return reference.contains(index);
        }
        return indexes.contains(index);
    }

    public boolean isEmpty() {
        if (reference != null) {
            return reference.isEmpty();
        }
        return indexes.isEmpty();
    }

    public Set<Integer> getIndexes() {
        if (reference != null) {
            return reference.getIndexes();
        }

        return indexes;
    }

    public Bucket getReference() {
        List<Bucket> referenceChain = getReferenceChain();

        if (referenceChain.size() == 1) {
            return this;
        }

        return referenceChain.get(1); // Gets the second element in the list, which is the first reference. The first element is the bucket itself.
    }

    public List<Bucket> getReferenceChain() {
        List<Bucket> referenceChain = new ArrayList<>(List.of(this));
        addReferencesRecursively(referenceChain);

        return referenceChain;
    }

    private void addReferencesRecursively(List<Bucket> referenceChain) {
        if (reference != null) {
            referenceChain.addAll(reference.getReferenceChain());
        }
    }

    public void setReference(Bucket bucket) {
        this.reference = bucket;
    }
}
