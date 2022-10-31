package com.tomspencerlondon.supermarket.adapter.in.web;

import com.tomspencerlondon.supermarket.hexagon.domain.Money;
import java.io.Serializable;

public class MoneyDto implements Serializable {

  private int pounds;
  private int pence;

  public static MoneyDto from(Money money) {
    return new MoneyDto(money.pounds(), money.pence());
  }

  public MoneyDto(int pounds, int pence) {
    this.pounds = pounds;
    this.pence = pence;
  }

  public String asString() {
    return String.format("%d.%02d", pounds, pence);
  }
}
