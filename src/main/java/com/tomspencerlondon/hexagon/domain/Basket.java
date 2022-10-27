package com.tomspencerlondon.hexagon.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {

  private static final String BEANS = "Beans";
  private static final String COKE = "Coke";
  private static final String ORANGES = "Oranges";
  private final List<Item> items = new ArrayList<>();
  private Money total;
  private Money subTotal;
  private List<Discount> savings;

  public Basket() {
    total = new Money(0, 0);
    subTotal = new Money(0, 0);
    savings = new ArrayList<>();
  }

  public void add(Item item) {
    items.add(item);
    subTotal = addSubTotal(item);
    total = total.plus(price(item));
  }

  public List<Discount> savings() {
    return savings;
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
    return total;
  }

  private Money price(Item item) {
    if (isThreeForTwo(item.name())) {
      savings.add(Discount.THREE_FOR_TWO);
      return new Money(0, 0);
    } else if (isTwoForAPound(item.name())) {
      savings.add(Discount.TWO_FOR_A_POUND);
      return new Money(0, 30);
    } else if (isFruit(item.name())) {
      return item.fruitPrice();
    }

    return item.price();
  }

  private boolean isFruit(String productName) {
    return ORANGES.equals(productName);
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

  public Money totalSavings() {
    return subTotal.minus(total);
  }
}