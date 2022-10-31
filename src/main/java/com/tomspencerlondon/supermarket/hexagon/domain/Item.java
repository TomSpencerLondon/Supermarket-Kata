package com.tomspencerlondon.supermarket.hexagon.domain;
import java.math.BigDecimal;

public class Item {
  private ItemId id;
  private final String name;
  private final Money price;
  private final BigDecimal weight;
  private final ItemType itemType;

  public Item(ItemId itemId, String name, Money price, BigDecimal weight, ItemType itemType) {
    this.id = itemId;
    this.name = name;
    this.price = price;
    this.weight = weight;
    this.itemType = itemType;
  }

  public Item(String name, Money price, BigDecimal weight, ItemType itemType) {
    this.name = name;
    this.price = price;
    this.weight = weight;
    this.itemType = itemType;
  }

  public ItemId getId() {
    return id;
  }

  public Money price() {
    return price;
  }

  public String name() {
    return name;
  }

  public BigDecimal weight() {
    return weight;
  }

  Money fruitPrice() {
    return price().times(weight());
  }

  public ItemType itemType() {
    return itemType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Item item = (Item) o;

    if (!name.equals(item.name)) {
      return false;
    }
    if (!price.equals(item.price)) {
      return false;
    }
    if (!weight.equals(item.weight)) {
      return false;
    }
    return itemType == item.itemType;
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + price.hashCode();
    result = 31 * result + weight.hashCode();
    result = 31 * result + itemType.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "Item{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", weight=" + weight + ", itemType=" + itemType + '}';
  }
}
