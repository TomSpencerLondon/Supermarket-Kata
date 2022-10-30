package com.tomspencerlondon.hexagon.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pricer {
  private static final String ORANGES = "Oranges";
  private Money total;
  private Money subTotal;
  private final List<Saving> savings;

  public Pricer(Money total, Money subTotal) {
    this.total = total;
    this.subTotal = subTotal;
    this.savings = new ArrayList<>();
  }

  public void addSubTotal(Item item) {
    if (isFruit(item.name())) {
      subTotal = subTotal.plus(item.fruitPrice());
    } else {
      subTotal = subTotal.plus(item.price());
    }
  }

  public void addTotal(Money money) {
    total = total.plus(money);
  }

  private boolean isFruit(String productName) {
    return ORANGES.equals(productName);
  }

  public Money subTotal() {
    return subTotal;
  }

  public Money total() {
    return total;
  }

  public Money totalSavings() {
    return subTotal.minus(total);
  }

  public List<Saving> savings() {
    return savings;
  }

  public void addTwoForAPoundSaving(Item item) {
    savings.add(twoForAPoundSaving(item));
  }

  public void addThreeForTwoSaving(Item item) {
    savings.add(threeForTwoSaving(item));
  }

  public void addToTotal(Item item, Discount discount) {
    addSubTotal(item);
    totalWithDiscount(item, discount);
  }

  private void totalWithDiscount(Item item, Discount discount) {
    if (discount == Discount.THREE_FOR_TWO) {
      addThreeForTwoSaving(item);
      addTotal(new Money(0, 0));
    } else if (discount == Discount.TWO_FOR_A_POUND) {
      addTwoForAPoundSaving(item);
      addTotal(priceForSecondOfTwoForAPound(item));
    } else if (isFruit(item.name())) {
      addTotal(item.fruitPrice());
    } else if (discount == Discount.NONE) {
      addTotal(item.price());
    }
  }

  private Money priceForSecondOfTwoForAPound(Item item) {
    return new Money(1, 0).minus(item.price());
  }

  private Saving threeForTwoSaving(Item item) {
    return new Saving(item.name(), Discount.THREE_FOR_TWO, item.price());
  }

  private Saving twoForAPoundSaving(Item item) {
    return new Saving(item.name(), Discount.TWO_FOR_A_POUND,
        item.price().times(new BigDecimal(2)).minus(new Money(1, 0)));
  }
}