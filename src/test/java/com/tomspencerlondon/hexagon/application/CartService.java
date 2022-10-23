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
    sum += product.price();
  }
}
