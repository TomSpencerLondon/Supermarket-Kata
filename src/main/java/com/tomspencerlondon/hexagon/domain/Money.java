package com.tomspencerlondon.hexagon.domain;

public class Money {
  private final int pounds;
  private final int pence;

  public Money(int pounds, int pence) {
    this.pounds = pounds;
    this.pence = pence;
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
