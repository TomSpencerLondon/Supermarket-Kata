package com.tomspencerlondon.supermarket.hexagon.domain;

public class Saving {

  private String itemName;
  private Discount discount;
  private Money itemCost;

  public Saving(String itemName, Discount discount, Money itemCost) {
    this.itemName = itemName;
    this.discount = discount;
    this.itemCost = itemCost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Saving saving = (Saving) o;

    if (!itemName.equals(saving.itemName)) {
      return false;
    }
    if (discount != saving.discount) {
      return false;
    }
    return itemCost.equals(saving.itemCost);
  }

  @Override
  public int hashCode() {
    int result = itemName.hashCode();
    result = 31 * result + discount.hashCode();
    result = 31 * result + itemCost.hashCode();
    return result;
  }
}
