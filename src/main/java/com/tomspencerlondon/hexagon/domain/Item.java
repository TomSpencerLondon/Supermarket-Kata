package com.tomspencerlondon.hexagon.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {

  private final String productName;
  private final double productPrice;
  private BigDecimal weight;

  public Item(String productName, double productPrice, BigDecimal weight) {
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

  public BigDecimal weight() {
    return weight;
  }

  double fruitPrice() {
    return BigDecimal.valueOf(price()).multiply(weight())
        .setScale(2, RoundingMode.HALF_UP)
        .doubleValue();
  }

  public Money fruitPriceInMoney() {
    BigDecimal bigDecimal = BigDecimal.valueOf(price()).multiply(weight());
    int pence = BigDecimal.valueOf(BigDecimal.valueOf(price()).multiply(weight())
        .setScale(2, RoundingMode.HALF_UP).doubleValue() * 100).intValue();

    return new Money(bigDecimal.intValue(), pence);
  }
 }
