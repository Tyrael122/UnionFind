package org.example;

import java.util.Scanner;

public class Main {
    private static UnionFind unionFind = new UnionFind(10);
    private static UnionFindFormatter unionFindFormatter;

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        initializeVariables();

        System.out.println("Welcome to Union Find!");


        int inputtedValue;
        do {
            showMenu();
            inputtedValue = in.nextInt();

            String returnString = doSelectedOption(inputtedValue);
//            printSeparator();

            System.out.println(returnString);
        } while (inputtedValue != MenuOption.EXIT.ordinal());
    }

    private static String doSelectedOption(int inputtedValue) {
        if (inputtedValue >= MenuOption.values().length) {
            return "Invalid option selected.";
        }

        MenuOption selectedOption = MenuOption.values()[inputtedValue];
        try {
            validateSelectedOption(selectedOption);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            return "";
        }

        switch (selectedOption) {
            case CREATE -> {
                int size = askForInteger("Please enter the size of the union find object: ");
                unionFind = new UnionFind(size);
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

    private static void validateSelectedOption(MenuOption selectedOption) {
        if (selectedOption == MenuOption.EXIT) {
            return;
        }

        if (selectedOption != MenuOption.CREATE && unionFind == null) {
            throw new IllegalStateException("You must create a union find object first.");
        }
    }

    private static int askForInteger(String prompt) {
        System.out.print(prompt);
        return in.nextInt();
    }

    private static int askForIndex(String indexOrdinal) {
        return askForInteger("Please enter the " + indexOrdinal + " index: ");
    }

    private static void initializeVariables() {
        unionFindFormatter = new UnionFindFormatter(unionFind);
    }

    private static void showMenu() {
        System.out.println("Please select an option:");
        for (MenuOption option : MenuOption.values()) {
            System.out.println(option.ordinal() + " - " + option + " - " + option.getDescription());
        }
    }

    private static void printSeparator() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
        System.out.println("--------------------------------------------------");
    }
}