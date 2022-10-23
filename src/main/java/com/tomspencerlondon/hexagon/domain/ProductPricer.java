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
    if (isThreeForTwo("Beans")) {
      return 0;
    } else if (isTwoForAPound("Coke")) {
      return 0.30;
    }

    return product.price();
  }

  private boolean isTwoForAPound(String productName) {
    return products.size() != 0 &&
        countForProduct(productName) != 0 &&
        countForProduct(productName) % 2 == 0;
  }

  private boolean isThreeForTwo(String productName) {
    return products.size() != 0 &&
        countForProduct(productName) != 0 &&
        countForProduct(productName) % 3 == 0;
  }

  private long countForProduct(String productName) {
    return products.stream().filter(p -> productName.equals(p.name())).count();
  }
}