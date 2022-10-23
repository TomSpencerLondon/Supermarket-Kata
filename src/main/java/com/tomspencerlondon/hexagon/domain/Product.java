package com.tomspencerlondon.hexagon.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

  private ProductId productId;
  private final String productName;
  private final double productPrice;
  private double weight;

  public Product(ProductId productId, String productName, double productPrice, double weight) {
    this.productId = productId;
    this.productName = productName;
    this.productPrice = productPrice;
    this.weight = weight;
  }

  public ProductId getId() {
    return productId;
  }

  public void setId(ProductId productId) {
    this.productId = productId;
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
    return BigDecimal.valueOf(price() * weight()).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }
}
