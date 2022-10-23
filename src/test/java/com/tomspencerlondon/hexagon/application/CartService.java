package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartService {

  private final List<Product> products = new ArrayList<>();
  private double sum = 0.0;

  public double totalPrice() {
    return sum;
  }

  public void add(Product product) {
    products.add(product);
    if (products.stream().filter(p -> "Beans".equals(p.name())).count() % 3 == 0) {
      return;
    }

    sum += product.price();
  }
}
