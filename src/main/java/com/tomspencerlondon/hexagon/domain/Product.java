package com.tomspencerlondon.hexagon.domain;

public class Product {

  private ProductId productId;
  private String productName;
  private double productPrice;

  public Product(ProductId productId, String productName, double productPrice) {
    this.productId = productId;
    this.productName = productName;
    this.productPrice = productPrice;
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
}
