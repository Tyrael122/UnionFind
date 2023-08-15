package org.example.menus.bucket;

import org.example.interfaces.MenuOption;

public enum BucketUnionFindMenuOption implements MenuOption {
    CREATE("Create a new union find object with the specified size"),
    UNION("Makes the union between two points"),
    IS_CONNECTED("Checks whether two points are connected."),
    SHOW_BUCKETS("Shows the buckets of the union find object"),
    EXIT("Exits the program");

    private final String description;

    BucketUnionFindMenuOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
