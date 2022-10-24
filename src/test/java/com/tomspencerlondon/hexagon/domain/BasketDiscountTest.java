package com.tomspencerlondon.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasketDiscountTest {

  @Test
  void threeBeansDiscountedToPriceOfTwo() {
    Basket basket = new Basket();
    basket.add(new Item("Beans", 0.50, 0));
    basket.add(new Item("Beans", 0.50, 0));
    basket.add(new Item("Beans", 0.50, 0));

    assertThat(basket.totalToPay())
        .isEqualTo(1.0);
  }

  @Test
  void twoCansOfCokeDiscountedToOnePound() {
    Basket basket = new Basket();
    basket.add(new Item("Coke", 0.70, 0));
    basket.add(new Item("Coke", 0.70, 0));

    assertThat(basket.totalToPay())
        .isEqualTo(1.0);
  }

}
