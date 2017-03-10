package br.com.hossomi.bar.service;

import br.com.hossomi.bar.model.Cart;
import br.com.hossomi.bar.model.Product;

public class CartService {

    private Cart currentCart = new Cart();

    public void addToCart(Product product, int quantity) {
        currentCart.addItem(product, quantity);
    }

    public Cart getCurrentCart() {
        return currentCart;
    }
}
