package com.tomspencerlondon.hexagon.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MoneyTest {

  @Test
  void tenPoundsPlusTenPoundsIsTwentyPounds() {
    Money first = new Money(10, 0);
    Money second = new Money(10, 0);

    assertThat(first.plus(second))
        .isEqualTo(new Money(20, 0));
  }

  @Test
  void fifteenPoundsMinusFivePoundsIsTenPounds() {
    Money first = new Money(15, 0);
    Money second = new Money(5, 0);

    assertThat(first.minus(second))
        .isEqualTo(new Money(10, 0));
  }

  @Test
  void onePoundMinusSeventyPenceIsThirtyPence() {
    Money first = new Money(1, 0);
    Money second = new Money(0, 70);

    assertThat(first.minus(second))
        .isEqualTo(new Money(0, 30));
  }

  @Test
  void thirtyPenceMinusTenPenceIsTwentyPence() {
    Money first = new Money(0, 30);
    Money second = new Money(0, 10);

    assertThat(first.minus(second))
        .isEqualTo(new Money(0, 20));
  }

  @Test
  void twentyPenceMinusThirtyPenceIsMinusTenPence() {
    Money first = new Money(0, 20);
    Money second = new Money(0, 30);

    assertThat(first.minus(second))
        .isEqualTo(new Money(0, -10));
  }
}