package br.com.hossomi.bar.menu.option;

import br.com.hossomi.bar.service.MenuService;

/**
 * Implementa a interface {@link Option}, fazendo com que ela volte para o menu anterior através do
 * {@link MenuService} quando selecionada.
 */
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
