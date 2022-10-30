package com.tomspencerlondon.supermarket.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class BasketDiscountTest {

  private static final Money BEANS_PRICE = new Money(0, 50);
  private static final Money COKE_PRICE = new Money(0, 70);
  private static final BigDecimal DEFAULT_WEIGHT = new BigDecimal(0);

  @Test
  void threeBeansDiscountedToPriceOfTwo() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));
    Item beans = new Item("Beans", BEANS_PRICE, DEFAULT_WEIGHT);
    basket.add(beans);
    basket.add(beans);
    basket.add(beans);

    assertThat(basket.totalToPay())
        .isEqualTo(new Money(1, 0));
  }

  @Test
  void twoCansOfCokeDiscountedToOnePound() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));
    Item coke = new Item("Coke", new Money(0, 70), DEFAULT_WEIGHT);
    basket.add(coke);
    basket.add(coke);

    assertThat(basket.totalToPay())
        .isEqualTo(new Money(1, 0));
  }

  @Test
  void fourCansOfBeansCostsSameAsPriceForThree() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));
    addBeansTo(basket, 4);

    assertThat(basket.totalToPay())
        .isEqualTo(BEANS_PRICE.times(new BigDecimal(3)));
  }

  @Test
  void cartWithSixCansOfBeansCostsSameAsPriceForFour() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));

    addBeansTo(basket, 6);

    assertThat(basket.totalToPay())
        .isEqualTo(new Money(2, 0));
  }

  @Test
  void showTotalSavingsAfterAddingSixBeans() {
    Basket basket = new Basket(
        new Receipt(
            new Money(0, 0),
            new Money(0, 0)));

    addBeansTo(basket, 6);

    assertThat(basket.totalSavings())
        .isEqualTo(new Money(1, 0));
  }

  @Test
  void showListOfSavingsAfterAddingThreeBeansAndTwoCokes() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));
    addBeansTo(basket, 3);
    Item coke = new Item("Coke", COKE_PRICE, DEFAULT_WEIGHT);
    basket.add(coke);
    basket.add(coke);

    assertThat(basket.receipt.savings())
        .containsExactly(
            new Saving("Beans", Discount.THREE_FOR_TWO, new Money(0, 50)),
            new Saving("Coke", Discount.TWO_FOR_A_POUND, new Money(0, 40)));
  }

  private void addBeansTo(Basket basket, int numberOfBeans) {
    Item beans = new Item("Beans", BEANS_PRICE, DEFAULT_WEIGHT);
    for (int i = 0; i < numberOfBeans; i++) {
      basket.add(beans);
    }
  }
}
