package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.domain.Product;
import com.tomspencerlondon.hexagon.domain.ProductPricer;

public class CartService {

  private final ProductPricer productPricer = new ProductPricer();

  public double totalPrice() {
    return productPricer.sum();
  }

  public void add(Product product) {
    productPricer.add(product);
  }

}
