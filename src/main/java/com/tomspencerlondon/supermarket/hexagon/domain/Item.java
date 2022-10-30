package com.tomspencerlondon.supermarket.hexagon.domain;

import java.math.BigDecimal;

public class Item {

  private final String productName;
  private final Money productPrice;
  private BigDecimal weight;

  public Item(String productName, Money productPrice, BigDecimal weight) {
    this.productName = productName;
    this.productPrice = productPrice;
    this.weight = weight;
  }

  public Money price() {
    return productPrice;
  }

  public String name() {
    return productName;
  }

  public BigDecimal weight() {
    return weight;
  }

  Money fruitPrice() {
    return price().times(weight());
  }
 }
