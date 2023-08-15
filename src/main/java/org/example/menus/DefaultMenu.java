package org.example.menus;

import org.example.interfaces.MenuOption;
import org.example.interfaces.MenuOptionHandler;
import org.example.interfaces.UnionFindAlgorithm;
import org.example.interfaces.UnionFindMenu;
import org.example.unionfind.algorithms.QuickFind;

import static org.example.Main.askForIndex;
import static org.example.Main.askForInteger;

public class DefaultMenu implements UnionFindMenu, MenuOptionHandler {
    private final MenuOption[] unionOptions = DefaultMenuOptions.values();
    protected UnionFindAlgorithm unionFindAlgorithm = new QuickFind(10);
    private final MenuOptionHandler menuOptionHandler;

    public DefaultMenu(UnionFindAlgorithm unionFindAlgorithm) {
        this.unionFindAlgorithm = unionFindAlgorithm;
        this.menuOptionHandler = this;
    }

    protected DefaultMenu() {
        this.menuOptionHandler = this;
    }

    @Override
    public String doOption(MenuOption option) {
        switch ((DefaultMenuOptions) option) {
            case CREATE -> {
                return create();
            }
            case UNION -> {
                return union();
            }
            case IS_CONNECTED -> {
                return isConnected();
            }
        }

        return menuOptionHandler.handleOption(option);
    }
    public String union() {
        int a = askForIndex("first");
        int b = askForIndex("second");
        unionFindAlgorithm.union(a, b);

        return "Union between " + a + " and " + b + " made.";
    }

    public String isConnected() {
        int a = askForIndex("first");
        int b = askForIndex("second");
        boolean connected = unionFindAlgorithm.isConnected(a, b);

        return a + " and " + b + " are " + (connected ? "" : "not ") + "connected.";
    }

    public String create() {
        int size = askForInteger("Please enter the size of the union find object: ");
        unionFindAlgorithm = new QuickFind(size);
        System.out.println("Union find object created with size " + size);
        return "";
    }

    @Override
    public String handleOption(MenuOption option) {
        return "Invalid option selected. Try again.";
    }

    @Override
    public MenuOption[] getMenuOptions() {
        return unionOptions;
    }

    protected void setAlgorithm(UnionFindAlgorithm unionFind) {
        this.unionFindAlgorithm = unionFind;
    }
}
