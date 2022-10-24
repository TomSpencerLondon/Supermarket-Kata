package com.tomspencerlondon.hexagon.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {

  private final String productName;
  private final double productPrice;
  private double weight;

  public Item(String productName, double productPrice, double weight) {
    this.productName = productName;
    this.productPrice = productPrice;
    this.weight = weight;
  }

  public double price() {
    return productPrice;
  }

  public String name() {
    return productName;
  }

  public double weight() {
    return weight;
  }

  double fruitPrice() {
    return BigDecimal.valueOf(price() * weight())
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }
}
