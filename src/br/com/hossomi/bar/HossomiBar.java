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

    /**
     * A aplicação se inicia no método main(String[]) (deve ser public static e receber um parâmetro
     * String[]).
     *
     * Ele pode estar em qualquer classe e pode haver mais de um, mas a aplicação inicia-se apenas
     * por um deles.
     *
     * @param args Parâmetros passados para a aplicação ao ser executada.
     */
    public static void main(String[] args) {
        /*
         * Essa aplicação foi estruturada em 3 camadas:
         * 
         * MODELO: define a forma que os dados da aplicação são guardados.
         * 
         * SERVIÇO: contém a lógica da aplicação, utilizando e manipulando os dados na camada de
         * modelo.
         * 
         * CONTROLE: obtém entrada de usuário e controla o fluxo da aplicação utilzando os serviços.
         * Nesse caso, ele também mostra saída ao usuário.
         * 
         * Normalmente, serviços e controladores são objetos únicos (singletons), então vamos
         * criá-los agora.
         */
        MenuService menuService = new MenuService();
        CartService cartService = new CartService();
        MenuController menuController = new MenuController(menuService);

        /*
         * Os menus foram projetados para pertencer à camada de serviço. Eles implementam lógica da
         * aplicação utilizando também outros serviços.
         *
         * Aqui construímos os menus da aplicação.
         */
        Menu productMenu = new Menu("Buy", "What would you like?");
        productMenu.addOption(new ProductOption(Product.HAMBURGER, cartService));
        productMenu.addOption(new ProductOption(Product.PASTA, cartService));
        productMenu.addOption(new ProductOption(Product.FULL_MEAL, cartService));
        productMenu.addOption(new ProductOption(Product.JUICE, cartService));
        productMenu.addOption(new ProductOption(Product.BEER, cartService));
        productMenu.addOption(new BackOption(menuService));

        Menu mainMenu = new Menu("Main", "Welcome to Hossomi Bar! How can I help you?");
        mainMenu.addOption(new SubMenuOption(productMenu, menuService));
        mainMenu.addOption(new ShowCartOption(cartService));
        mainMenu.addOption(new BackOption(menuService));

        /*
         * Como não temos um "estado inicial" da aplicação (o carriho estÁ vazio), nâo precisamos
         * fazer nada na camada de modelo; ela não precisa ser configurada nem inicializada.
         */

        /*
         * Agora que temos os menus, iniciamos o serviço de menus com o primeiro menu.
         */
        menuService.enter(mainMenu);

        /*
         * Agora que a lógica da aplicação foi configurada e inicializada (através dos serviços),
         * podemos iniciar o controlador que vai iniciar o fluxo da aplicação.
         */
        menuController.execute();
    }
}
