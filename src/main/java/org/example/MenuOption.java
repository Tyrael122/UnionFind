package org.example;

public enum MenuOption {
    CREATE("Create a new union find object with the specified size"),
    UNION("Makes the union between two points"),
    CONNECTED("Checks whether two points are connected."),
    SHOW_BUCKETS("Shows the buckets of the union find object"),
    EXIT("Exits the program");

    private final String description;

    MenuOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
