package com.tomspencerlondon.supermarket.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class BasketTest {

  @Test
  void beforeAddingItemTotalToPayIsZeroAndThereAreNoItems() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));

    assertThat(basket.totalToPay())
        .isEqualTo(new Money(0, 0));
    assertThat(basket.items())
        .isEmpty();
  }

  @Test
  void addOneItemHasPriceForOneItemAndItemIsShown() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));

    Item item = new Item(ItemId.of(1L), "Beans", new Money(0, 50), new BigDecimal(0), ItemType.NORMAL);
    basket.add(item);

    assertThat(basket.totalToPay())
        .isEqualTo(new Money(0, 50));

    assertThat(basket.items())
        .containsExactly(item);
  }

  @Test
  void orangesArePricedBasedOnWeight() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));
    basket.add(new Item(ItemId.of(1L), "Oranges", new Money(1, 99), new BigDecimal(0.2), ItemType.FRUIT));

    assertThat(basket.totalToPay())
        .isEqualTo(new Money(0, 40));
  }

  @Test
  void addTwoItemsHasPriceForTwoItems() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));

    Item item = new Item(ItemId.of(1L), "Beans", new Money(0, 50), new BigDecimal(0), ItemType.NORMAL);
    basket.add(item);
    basket.add(item);

    assertThat(basket.totalToPay())
        .isEqualTo(new Money(1, 0));
    assertThat(basket.items())
        .containsExactly(item, item);
  }

  @Test
  void addTwoItemsGivesSubtotal() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));
    Item item = new Item(ItemId.of(1L), "Beans", new Money(0, 50), new BigDecimal(0), ItemType.NORMAL);
    basket.add(item);
    basket.add(item);
    basket.add(item);

    assertThat(basket.subTotal())
        .isEqualTo(new Money(1, 50));
  }

  @Test
  void addOrangesShowsFruitPriceSubtotal() {
    Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));
    Item item = new Item(ItemId.of(1L), "Oranges", new Money(1, 99), new BigDecimal(0.2), ItemType.NORMAL);
    basket.add(item);

    assertThat(basket.subTotal())
        .isEqualTo(new Money(0, 40));
  }
}