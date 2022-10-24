package com.tomspencerlondon.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BasketDiscountTest {

  private static final double BEANS_PRICE = 0.50;

  @Test
  void threeBeansDiscountedToPriceOfTwo() {
    Basket basket = new Basket();
    Item beans = new Item("Beans", BEANS_PRICE, 0);
    basket.add(beans);
    basket.add(beans);
    basket.add(beans);

    assertThat(basket.totalToPay())
        .isEqualTo(1.0);
  }

  @Test
  void twoCansOfCokeDiscountedToOnePound() {
    Basket basket = new Basket();
    Item coke = new Item("Coke", 0.70, 0);
    basket.add(coke);
    basket.add(coke);

    assertThat(basket.totalToPay())
        .isEqualTo(1.0);
  }

  @Test
  void fourCansOfBeansCostsSameAsPriceForThree() {
    Basket basket = new Basket();
    addBeansTo(basket, 4);

    assertThat(basket.totalToPay())
        .isEqualTo(BEANS_PRICE * 3);
  }

  @Test
  void cartWithSixCansOfBeansCostsSameAsPriceForFour() {
    Basket basket = new Basket();

    addBeansTo(basket, 6);

    assertThat(basket.totalToPay())
        .isEqualTo(2.00);
  }

  private void addBeansTo(Basket basket, int numberOfBeans) {
    Item beans = new Item("Beans", BEANS_PRICE, 0);
    for (int i = 0; i < numberOfBeans; i++) {
      basket.add(beans);
    }
  }
}
