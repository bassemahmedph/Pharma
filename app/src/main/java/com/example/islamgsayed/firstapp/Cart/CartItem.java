package com.example.islamgsayed.firstapp.Cart;

import com.example.islamgsayed.firstapp.amrads_ha23a.product;

public class CartItem {
    public product product;
    public int quantity;

    public CartItem(com.example.islamgsayed.firstapp.amrads_ha23a.product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
