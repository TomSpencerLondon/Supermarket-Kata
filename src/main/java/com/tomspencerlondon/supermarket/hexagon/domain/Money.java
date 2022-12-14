package com.tomspencerlondon.supermarket.hexagon.domain;

import java.math.BigDecimal;

public class Money {
  private final int pounds;
  private final int pence;

  public Money(int pounds, int pence) {
    this.pounds = pounds;
    this.pence = pence;
  }

  public static Money toMoney(BigDecimal bigDecimal) {
    long amount = Math.round(bigDecimal.doubleValue() * 100);

    return new Money((int) (amount / 100), (int) (amount % 100));
  }

  public int pounds() {
    return pounds;
  }

  public int pence() {
    return pence;
  }

  public Money plus(Money money) {
    int newPounds = (((money.pounds() + pounds) * 100) + money.pence() + pence) / 100;
    int newPence = (money.pence() + pence) % 100;

    return new Money(newPounds, newPence);
  }

  public Money minus(Money money) {
    int newPounds = pounds;
    int newPence;
    if (money.pence() > pence && newPounds > 0) {
      newPounds -= 1;
      newPence = (100 + pence) - money.pence();
    } else {
      newPounds = (((pounds - money.pounds()) * 100) - (money.pence() - pence)) / 100;
      newPence = (pence - money.pence()) % 100;
    }

    return new Money(newPounds, newPence);
  }

  public Money times(BigDecimal multiplicand) {
    long amount = Math.round(multiplicand.doubleValue() * ((pounds * 100) + pence));

    return new Money((int) (amount / 100), (int) (amount % 100));
  }

  @Override
  public String toString() {
    return "Money{" + "pounds=" + pounds + ", pence=" + pence + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Money money = (Money) o;

    if (pounds != money.pounds) {
      return false;
    }
    return pence == money.pence;
  }

  @Override
  public int hashCode() {
    int result = pounds;
    result = 31 * result + pence;
    return result;
  }
}
