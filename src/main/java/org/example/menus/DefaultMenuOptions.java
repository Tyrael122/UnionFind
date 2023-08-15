package org.example.menus;

import org.example.interfaces.MenuOption;

public enum DefaultMenuOptions implements MenuOption {
    CREATE("Create a new union find object with the specified size"),
    UNION("Makes the union between two points"),
    IS_CONNECTED("Checks whether two points are connected."),
    EXIT("Exits the program");

    private final String description;

    DefaultMenuOptions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
