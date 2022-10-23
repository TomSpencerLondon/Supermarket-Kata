package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.domain.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartService {

  private final List<Product> products = new ArrayList<>();

  public double totalPrice() {
    return products.stream().map(Product::price)
        .mapToDouble(Double::doubleValue).sum();
  }

  public void add(Product product) {
    products.add(product);
  }
}
