package com.tomspencerlondon.hexagon.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void pricesThreeBeansForTwo() {
    Order order = new Order();
    order.add(new Item("Beans", 0.50, 0));
    order.add(new Item("Beans", 0.50, 0));
    order.add(new Item("Beans", 0.50, 0));

    assertThat(order.sum())
        .isEqualTo(1.0);
  }

  @Test
  void twoCansOfCokeForOnePound() {
    Order order = new Order();
    order.add(new Item("Coke", 0.70, 0));
    order.add(new Item("Coke", 0.70, 0));

    assertThat(order.sum())
        .isEqualTo(1.0);
  }

  @Test
  void TwoHundredGramsOrangesCost40pence() {
    Order order = new Order();
    order.add(new Item("Oranges", 1.99, 0.2));

    assertThat(order.sum())
        .isEqualTo(0.40);
  }
}