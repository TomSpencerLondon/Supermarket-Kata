package com.tomspencerlondon.supermarket.hexagon.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class ItemTest {

  @Test
  void fruitPriceIsByWeight() {
    Item oranges = new Item(ItemId.of(1L), "Oranges", new Money(1, 99), new BigDecimal(0.2), ItemType.FRUIT);

    assertThat(oranges.fruitPrice())
        .isEqualTo(new Money(0, 40));
  }
}
