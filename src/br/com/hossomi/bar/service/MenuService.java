package br.com.hossomi.bar.service;

import java.util.LinkedList;
import java.util.List;

import br.com.hossomi.bar.menu.Menu;
import br.com.hossomi.bar.menu.option.MenuOption;

public class MenuService {

    private LinkedList<Menu> menuStack = new LinkedList<>();

    public Menu getCurrentMenu() {
        return !menuStack.isEmpty()
                ? menuStack.getFirst()
                : null;
    }

    public void back() {
        if (menuStack.size() > 0) {
            menuStack.pop();
        }
    }

    public void enter(Menu menu) {
        menuStack.push(menu);
    }

    public void selectOption(int option) {
        Menu menu = getCurrentMenu();
        List<MenuOption> options = menu.getOptions();
        options.get(option).select();
    }
}
