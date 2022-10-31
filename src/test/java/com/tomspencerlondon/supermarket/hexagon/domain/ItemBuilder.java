package com.tomspencerlondon.supermarket.hexagon.domain;

import java.math.BigDecimal;

public class ItemBuilder {

  private String name;
  private Money price;
  private BigDecimal weight;
  private ItemType itemType;

  public ItemBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public ItemBuilder withPrice(Money price) {
    this.price = price;
    return this;
  }

  public ItemBuilder withWeight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  public ItemBuilder withItemType(ItemType itemType) {
    this.itemType = itemType;
    return this;
  }

  public Item build() {
    return new Item(name, price, weight, itemType);
  }
}
