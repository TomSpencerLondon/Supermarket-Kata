package com.tomspencerlondon.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class BasketTest {

  @Test
  void beforeAddingItemTotalToPayIsZeroAndThereAreNoItems() {
    Basket basket = new Basket();

    assertThat(basket.totalToPay())
        .isEqualTo(0);
    assertThat(basket.items())
        .isEmpty();
  }

  @Test
  void addOneItemHasPriceForOneItemAndItemIsShown() {
    Basket basket = new Basket();

    Item item = new Item("Beans", 0.50, new BigDecimal(0));
    basket.add(item);

    assertThat(basket.totalToPay())
        .isEqualTo(0.50);

    assertThat(basket.items())
        .containsExactly(item);
  }

  @Test
  void orangesArePricedBasedOnWeight() {
    Basket basket = new Basket();
    basket.add(new Item("Oranges", 1.99, new BigDecimal(0.2)));

    assertThat(basket.totalToPay())
        .isEqualTo(0.40);
  }

  @Test
  void addTwoItemsHasPriceForTwoItems() {
    Basket basket = new Basket();

    Item item = new Item("Beans", 0.50, new BigDecimal(0));
    basket.add(item);
    basket.add(item);

    assertThat(basket.totalToPay())
        .isEqualTo(1.00);
    assertThat(basket.items())
        .containsExactly(item, item);
  }
}