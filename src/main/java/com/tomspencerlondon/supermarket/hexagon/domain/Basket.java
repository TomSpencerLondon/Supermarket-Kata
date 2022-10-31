package com.tomspencerlondon.supermarket.hexagon.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {

  private static final String BEANS = "Beans";
  private static final String COKE = "Coke";
  private final List<Item> items = new ArrayList<>();
  final Receipt receipt;

  public Basket(Receipt receipt) {
    this.receipt = receipt;
  }

  public void add(Item item) {
    items.add(item);
    receipt.addToTotal(item, discount(item));
  }

  public List<Item> items() {
    return items;
  }

  public Money subTotal() {
    return receipt.subTotal();
  }

  public Money totalToPay() {
    return receipt.totalToPay();
  }

  public Money totalSavings() {
    return receipt.totalSavings();
  }

  private Discount discount(Item item) {
    if (isThreeForTwo(item.name())) {
      return Discount.THREE_FOR_TWO;
    } else if (isTwoForAPound(item.name())) {
      return Discount.TWO_FOR_A_POUND;
    }

    return Discount.NONE;
  }

  private boolean isTwoForAPound(String productName) {
    return items.size() != 0 &&
        countForProduct(productName) != 0 &&
        countForProduct(productName) % 2 == 0 &&
        COKE.equals(productName);
  }

  private boolean isThreeForTwo(String productName) {
    return items.size() != 0 &&
        countForProduct(productName) != 0 &&
        countForProduct(productName) % 3 == 0 &&
        BEANS.equals(productName);
  }

  private long countForProduct(String productName) {
    return items.stream().filter(p -> productName.equals(p.name())).count();
  }

  public Receipt receipt() {
    return receipt;
  }
}