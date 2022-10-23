package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartService {

  private final List<Product> products = new ArrayList<>();

  public double totalPrice() {
    double sum = 0.0;
    for (Product product : products) {
      sum += product.price();
    }
    return sum;
  }

  public void add(Product product) {
    products.add(product);
  }
}
