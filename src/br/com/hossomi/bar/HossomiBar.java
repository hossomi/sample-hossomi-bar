package br.com.hossomi.bar;

import br.com.hossomi.bar.controller.MenuController;
import br.com.hossomi.bar.menu.Menu;
import br.com.hossomi.bar.menu.option.BackMenuOption;
import br.com.hossomi.bar.menu.option.ProductMenuOption;
import br.com.hossomi.bar.menu.option.ShowCartMenuOption;
import br.com.hossomi.bar.menu.option.SubMenuOption;
import br.com.hossomi.bar.model.Product;
import br.com.hossomi.bar.service.CartService;
import br.com.hossomi.bar.service.MenuService;

public class HossomiBar {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        CartService cartService = new CartService();

        Menu buyMenu = new Menu("Buy", "What would you like?");
        buyMenu.addOption(new ProductMenuOption(Product.HAMBURGER, cartService));
        buyMenu.addOption(new ProductMenuOption(Product.PASTA, cartService));
        buyMenu.addOption(new ProductMenuOption(Product.FULL_MEAL, cartService));
        buyMenu.addOption(new ProductMenuOption(Product.JUICE, cartService));
        buyMenu.addOption(new ProductMenuOption(Product.BEER, cartService));
        buyMenu.addOption(new BackMenuOption(menuService));

        Menu mainMenu = new Menu("Main", "Welcome to Hossomi Bar! How can I help you?");
        mainMenu.addOption(new SubMenuOption(buyMenu, menuService));
        mainMenu.addOption(new ShowCartMenuOption(cartService));
        mainMenu.addOption(new BackMenuOption(menuService));

        menuService.enter(mainMenu);

        MenuController menuController = new MenuController(menuService);
        menuController.execute();
    }
}
