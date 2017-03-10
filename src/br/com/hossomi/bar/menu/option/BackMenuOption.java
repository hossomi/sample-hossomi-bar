package br.com.hossomi.bar.menu.option;

import br.com.hossomi.bar.service.MenuService;

public class BackMenuOption implements MenuOption {

    private final MenuService menuService;

    public BackMenuOption(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public String getLabel() {
        return "Back";
    }

    @Override
    public void select() {
        menuService.back();
    }
}
