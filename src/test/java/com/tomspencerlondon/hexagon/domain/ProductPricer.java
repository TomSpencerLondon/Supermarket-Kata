package com.tomspencerlondon.hexagon.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductPricer {

  private final List<Product> products = new ArrayList<>();
  private double sum = 0.0;

  public ProductPricer() {
  }

  public double sum() {
    return sum;
  }

  public void add(Product product) {
    products.add(product);
    sum += price(product);
  }

  private double price(Product product) {
    if (products.stream().filter(p -> "Beans".equals(p.name())).count() % 3 == 0) {
      return 0;
    }

    return product.price();
  }
}