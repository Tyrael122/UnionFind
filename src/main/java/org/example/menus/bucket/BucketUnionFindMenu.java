package org.example.menus.bucket;

import org.example.interfaces.MenuOption;
import org.example.interfaces.UnionFindMenu;
import org.example.unionfind.algorithms.bucket.BucketUnionFindAlgorithm;
import org.example.unionfind.algorithms.bucket.UnionFindFormatter;

import static org.example.Main.askForIndex;
import static org.example.Main.askForInteger;

public class BucketUnionFindMenu implements UnionFindMenu {
    private final MenuOption[] unionOptions = BucketUnionFindMenuOption.values();
    private BucketUnionFindAlgorithm unionFind = new BucketUnionFindAlgorithm(10);
    private final UnionFindFormatter unionFindFormatter;

    public BucketUnionFindMenu() {
        unionFindFormatter = new UnionFindFormatter(unionFind);
    }

    public String doOption(MenuOption option) {
        switch ((BucketUnionFindMenuOption) option) {
            case CREATE -> {
                int size = askForInteger("Please enter the size of the union find object: ");
                unionFind = new BucketUnionFindAlgorithm(size);
                System.out.println("Union find object created with size " + size);
            }
            case UNION -> {
                int a = askForIndex("first");
                int b = askForIndex("second");
                unionFind.union(a, b);

                System.out.println("Union between " + a + " and " + b + " made.");
            }
            case IS_CONNECTED -> {
                int a = askForIndex("first");
                int b = askForIndex("second");
                boolean connected = unionFind.isConnected(a, b);

                return a + " and " + b + " are " + (connected ? "" : "not ") + "connected.";
            }
            case SHOW_BUCKETS -> {
                return "Buckets: " + unionFindFormatter.getFormattedBuckets();
            }
            default -> System.out.println("Invalid option selected. Try again.");
        }

        return "";
    }

    public MenuOption[] getMenuOptions() {
        return unionOptions;
    }
}
