package com.tomspencerlondon.hexagon.domain;

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
}
