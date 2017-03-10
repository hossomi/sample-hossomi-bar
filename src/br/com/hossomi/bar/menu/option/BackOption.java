package br.com.hossomi.bar.menu.option;

import br.com.hossomi.bar.service.MenuService;

public class BackOption implements Option {

    private final MenuService menuService;

    public BackOption(MenuService menuService) {
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
