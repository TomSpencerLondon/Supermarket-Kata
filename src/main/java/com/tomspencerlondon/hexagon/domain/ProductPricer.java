package com.tomspencerlondon.hexagon.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductPricer {

  private static final String BEANS = "Beans";
  private static final String COKE = "Coke";
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
    if (isThreeForTwo(BEANS)) {
      return 0;
    } else if (isTwoForAPound(COKE)) {
      return 0.30;
    } else if (isFruit(product.name())) {
      return product.fruitPrice();
    }

    return product.price();
  }

  private boolean isFruit(String productName) {
    return "Oranges".equals(productName);
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