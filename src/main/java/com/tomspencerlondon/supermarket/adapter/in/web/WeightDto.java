package com.tomspencerlondon.supermarket.adapter.in.web;

import com.tomspencerlondon.supermarket.hexagon.domain.Money;
import java.io.Serializable;
import java.math.BigDecimal;

public class WeightDto implements Serializable {
  int kilograms;
  int grams;

  public WeightDto(int kilograms, int grams) {
    this.kilograms = kilograms;
    this.grams = grams;
  }

  public static WeightDto toWeightDto(BigDecimal weight) {
    long kilograms = Math.round(weight.doubleValue() * 100);
    return new WeightDto((int) (kilograms / 100), (int) (kilograms % 100));
  }

  public int getKilograms() {
    return kilograms;
  }

  public int getGrams() {
    return grams;
  }

  public String asString() {
    return String.format("%d kg %d g", kilograms, grams);
  }
}
