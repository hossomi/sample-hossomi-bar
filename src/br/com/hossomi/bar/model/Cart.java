package br.com.hossomi.bar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o carrinho do usuário, contendo uma lista dos itens que está comprando.
 * Possui também métodos auxiliares que exibe os seus dados de outra forma, como {@link #getTotalCost()}.
 */
public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public double getTotalCost() {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getCost() * item.getQuantity())
                .sum();
    }
}
