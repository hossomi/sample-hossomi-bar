package br.com.hossomi.bar.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void clear() {
        items.clear();
    }

    public double getTotalCost() {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getCost() * item.getQuantity())
                .sum();
    }
}
