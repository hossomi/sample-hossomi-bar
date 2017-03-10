package br.com.hossomi.bar.menu.option;

import br.com.hossomi.bar.menu.Menu;
import br.com.hossomi.bar.service.MenuService;

public class SubMenuOption implements Option {

    private Menu subMenu;

    private final MenuService menuService;

    public SubMenuOption(Menu subMenu, MenuService menuService) {
        this.subMenu = subMenu;
        this.menuService = menuService;
    }

    @Override
    public String getLabel() {
        return subMenu.getLabel();
    }

    @Override
    public void select() {
        menuService.enter(subMenu);
    }
}
