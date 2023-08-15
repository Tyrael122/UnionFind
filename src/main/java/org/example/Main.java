package org.example;

import org.example.interfaces.MenuOption;
import org.example.interfaces.UnionFindMenu;
import org.example.menus.bucket.BucketUnionFindMenu;
import org.example.menus.bucket.BucketUnionFindMenuOption;

import java.util.Scanner;

public class Main {
    private static final UnionFindMenu menu = new BucketUnionFindMenu();
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Union Find!");

        int inputtedValue;
        do {
            showMenu();
            inputtedValue = in.nextInt();

            String returnString = doSelectedOption(inputtedValue);
//            printSeparator();

            System.out.println(returnString);
        } while (inputtedValue != BucketUnionFindMenuOption.EXIT.ordinal());
    }

    private static String doSelectedOption(int inputtedValue) {
        if (inputtedValue >= menu.getMenuOptions().length) {
            return "Invalid option selected.";
        }

        MenuOption selectedOption = menu.getMenuOptions()[inputtedValue];
        return menu.doOption(selectedOption);
    }

    public static int askForIndex(String indexOrdinal) {
        return askForInteger("Please enter the " + indexOrdinal + " index: ");
    }

    public static int askForInteger(String prompt) {
        System.out.print(prompt);
        return in.nextInt();
    }

    private static void showMenu() {
        System.out.println("Please select an option:");
        for (BucketUnionFindMenuOption option : BucketUnionFindMenuOption.values()) {
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