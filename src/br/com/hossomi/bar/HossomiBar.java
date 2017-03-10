package br.com.hossomi.bar;

import br.com.hossomi.bar.controller.MenuController;
import br.com.hossomi.bar.menu.Menu;
import br.com.hossomi.bar.menu.option.BackOption;
import br.com.hossomi.bar.menu.option.ProductOption;
import br.com.hossomi.bar.menu.option.ShowCartOption;
import br.com.hossomi.bar.menu.option.SubMenuOption;
import br.com.hossomi.bar.model.Product;
import br.com.hossomi.bar.service.CartService;
import br.com.hossomi.bar.service.MenuService;

public class HossomiBar {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        CartService cartService = new CartService();

        Menu buyMenu = new Menu("Buy", "What would you like?");
        buyMenu.addOption(new ProductOption(Product.HAMBURGER, cartService));
        buyMenu.addOption(new ProductOption(Product.PASTA, cartService));
        buyMenu.addOption(new ProductOption(Product.FULL_MEAL, cartService));
        buyMenu.addOption(new ProductOption(Product.JUICE, cartService));
        buyMenu.addOption(new ProductOption(Product.BEER, cartService));
        buyMenu.addOption(new BackOption(menuService));

        Menu mainMenu = new Menu("Main", "Welcome to Hossomi Bar! How can I help you?");
        mainMenu.addOption(new SubMenuOption(buyMenu, menuService));
        mainMenu.addOption(new ShowCartOption(cartService));
        mainMenu.addOption(new BackOption(menuService));

        menuService.enter(mainMenu);

        MenuController menuController = new MenuController(menuService);
        menuController.execute();
    }
}
