package org.example.menus;

import org.example.interfaces.MenuOption;
import org.example.interfaces.UnionFindMenu;
import org.example.unionfind.algorithms.QuickFind;

import static org.example.Main.askForIndex;
import static org.example.Main.askForInteger;

public class DefaultMenu implements UnionFindMenu {
    private final MenuOption[] unionOptions = DefaultMenuOptions.values();
    private QuickFind unionFind = new QuickFind(10);

    @Override
    public MenuOption[] getMenuOptions() {
        return new MenuOption[0];
    }

    @Override
    public String doOption(MenuOption option) {
        switch ((DefaultMenuOptions) option) {
            case CREATE -> {
                int size = askForInteger("Please enter the size of the union find object: ");
                unionFind = new QuickFind(size);
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
            default -> System.out.println("Invalid option selected. Try again.");
        }

        return "";
    }
}
