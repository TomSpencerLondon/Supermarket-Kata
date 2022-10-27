package com.tomspencerlondon.hexagon.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {

  private static final String BEANS = "Beans";
  private static final String COKE = "Coke";
  private final List<Item> items = new ArrayList<>();
  private Money sum;
  private Money subTotal;

  public Basket() {
    sum = new Money(0, 0);
    subTotal = new Money(0, 0);
  }

  public void add(Item item) {
    items.add(item);
    subTotal = addSubTotal(item);
    sum = sum.plus(price(item));
  }

  private Money addSubTotal(Item item) {
    if (isFruit(item.name())) {
      return subTotal.plus(item.fruitPrice());
    }

    return subTotal.plus(item.price());
  }

  public List<Item> items() {
    return items;
  }

  public Money subTotal() {
    return subTotal;
  }

  public Money totalToPay() {
    return sum;
  }

  private Money price(Item item) {
    if (isThreeForTwo(BEANS)) {
      return new Money(0, 0);
    } else if (isTwoForAPound(COKE)) {
      return new Money(0, 30);
    } else if (isFruit(item.name())) {
      return item.fruitPrice();
    }

    return item.price();
  }

  private boolean isFruit(String productName) {
    return "Oranges".equals(productName);
  }

  private boolean isTwoForAPound(String productName) {
    return items.size() != 0 &&
        countForProduct(productName) != 0 &&
        countForProduct(productName) % 2 == 0;
  }

  private boolean isThreeForTwo(String productName) {
    return items.size() != 0 &&
        countForProduct(productName) != 0 &&
        countForProduct(productName) % 3 == 0;
  }

  private long countForProduct(String productName) {
    return items.stream().filter(p -> productName.equals(p.name())).count();
  }
}