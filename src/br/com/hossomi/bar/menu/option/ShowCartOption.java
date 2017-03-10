package br.com.hossomi.bar.menu.option;

import java.util.List;

import br.com.hossomi.bar.model.Cart;
import br.com.hossomi.bar.model.CartItem;
import br.com.hossomi.bar.service.CartService;

import static br.com.hossomi.bar.util.Utils.formatCost;

public class ShowCartOption implements Option {

    private final CartService cartService;

    public ShowCartOption(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public String getLabel() {
        return "Show cart";
    }

    @Override
    public void select() {
        Cart cart = cartService.getCurrentCart();
        List<CartItem> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println("Your cart currently has:");
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            System.out.printf("%02d. %-20s %02dx %s\n",
                    i, item.getProduct().getName(), item.getQuantity(), formatCost(item.getProduct().getCost()));
        }
        System.out.printf("%28s %s\n",
                "Total:", formatCost(cart.getTotalCost()));
    }
}
