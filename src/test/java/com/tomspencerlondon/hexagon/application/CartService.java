package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.domain.Product;
import com.tomspencerlondon.hexagon.domain.ProductPricer;

public class CartService {
  private ProductPricer pricer;

  public CartService(ProductPricer pricer) {
    this.pricer = pricer;
  }

  public double totalPrice() {
    return pricer.sum();
  }

  public void add(Product product) {
    pricer.add(product);
  }

}
