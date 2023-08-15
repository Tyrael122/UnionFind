package org.example.menus.bucket;

import org.example.interfaces.MenuOption;
import org.example.interfaces.UnionFindMenu;
import org.example.menus.DefaultMenu;
import org.example.interfaces.MenuOptionHandler;
import org.example.unionfind.algorithms.bucket.BucketUnionFindAlgorithm;
import org.example.unionfind.algorithms.bucket.UnionFindFormatter;

public class BucketUnionFindDefaultMenu extends DefaultMenu implements UnionFindMenu, MenuOptionHandler {
    private final MenuOption[] unionOptions = BucketUnionFindMenuOption.values();
    private BucketUnionFindAlgorithm unionFind;
    private final UnionFindFormatter unionFindFormatter;

    public BucketUnionFindDefaultMenu() {
        super.setAlgorithm(unionFind);
        unionFind = new BucketUnionFindAlgorithm(10);
        unionFindFormatter = new UnionFindFormatter(unionFind);
    }

    public MenuOption[] getMenuOptions() {
        return unionOptions;
    }

    @Override
    public String handleOption(MenuOption option) {
        if (option == BucketUnionFindMenuOption.SHOW_BUCKETS) {
            return "Buckets: " + unionFindFormatter.getFormattedBuckets();
        }

        System.out.println("Invalid option selected. Try again.");
        return "";
    }
}
