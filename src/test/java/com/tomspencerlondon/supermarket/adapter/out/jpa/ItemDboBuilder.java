package com.tomspencerlondon.supermarket.adapter.out.jpa;

import java.math.BigDecimal;

public class ItemDboBuilder {

  private Long id;
  private String name;
  private BigDecimal price;
  private BigDecimal weight;
  private ItemType itemType;

  public ItemDboBuilder withId(Long id) {
    this.id = id;
    return this;
  }

  public ItemDboBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public ItemDboBuilder withPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public ItemDboBuilder withWeight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  public ItemDboBuilder withItemType(ItemType itemType) {
    this.itemType = itemType;
    return this;
  }

  public ItemDbo build() {
    ItemDbo itemDbo = new ItemDbo();
    itemDbo.setId(id);
    itemDbo.setItemName(name);
    itemDbo.setPrice(price);
    itemDbo.setWeight(weight);
    itemDbo.setItemType(itemType);
    return itemDbo;
  }
}
