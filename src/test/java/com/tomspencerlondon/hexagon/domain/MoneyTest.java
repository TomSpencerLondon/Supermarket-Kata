package com.tomspencerlondon.hexagon.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

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
}