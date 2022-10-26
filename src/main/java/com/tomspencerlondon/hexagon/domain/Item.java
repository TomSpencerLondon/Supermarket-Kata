package com.tomspencerlondon.hexagon.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

//  public Money fruitPriceInMoney() {
//    BigDecimal bigDecimal = BigDecimal.valueOf(price()).multiply(weight());
//    int pence = BigDecimal.valueOf(BigDecimal.valueOf(price()).multiply(weight())
//        .setScale(2, RoundingMode.HALF_UP).doubleValue() * 100).intValue();
//
//    return new Money(bigDecimal.intValue(), pence);
//  }
 }
