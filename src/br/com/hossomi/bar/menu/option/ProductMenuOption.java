package br.com.hossomi.bar.menu.option;

import br.com.hossomi.bar.menu.input.IntegerUserInput;
import br.com.hossomi.bar.model.Product;
import br.com.hossomi.bar.service.CartService;

import static br.com.hossomi.bar.util.Utils.formatCost;

public class ProductMenuOption implements MenuOption {

    private Product product;

    private final CartService cartService;

    public ProductMenuOption(Product product, CartService cartService) {
        this.cartService = cartService;
        this.product = product;
    }

    @Override
    public String getLabel() {
        return String.format("%-20s %s", product.getName(), formatCost(product.getCost()));
    }

    @Override
    public void select() {
        Integer quantity = new IntegerUserInput("Quantity").get();
        cartService.addToCart(product, quantity);
    }
}
