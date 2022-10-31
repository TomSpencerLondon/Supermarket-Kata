package com.tomspencerlondon.supermarket.adapter.out.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.supermarket.hexagon.domain.Item;
import com.tomspencerlondon.supermarket.hexagon.domain.ItemId;
import com.tomspencerlondon.supermarket.hexagon.domain.ItemType;
import com.tomspencerlondon.supermarket.hexagon.domain.Money;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class ItemTransformerTest {

  @Test
  void transformsBigDecimalToMoney() {
    ItemTransformer itemTransformer = new ItemTransformer();
    BigDecimal bigDecimal = new BigDecimal(1.50);

    assertThat(Money.toMoney(bigDecimal))
        .isEqualTo(new Money(1, 50));
  }

  @Test
  void transformsFruitDboToFruitItem() {
    ItemTransformer itemTransformer = new ItemTransformer();
    BigDecimal price = new BigDecimal(1.99);
    BigDecimal weight = new BigDecimal(0.2);
    ItemDbo itemDbo = new ItemDbo();
    itemDbo.setId(1L);
    itemDbo.setName("Oranges");
    itemDbo.setPrice(price);
    itemDbo.setWeight(weight);
    itemDbo.setItemType(com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType.FRUIT);

    Item item = itemTransformer.toItem(itemDbo);

    Item expected = new Item(ItemId.of(1L), "Oranges", new Money(1, 99), weight, ItemType.FRUIT);
    assertThat(item)
        .isEqualTo(expected);
  }

  @Test
  void transformsMoneyToBigDecimal() {
    ItemTransformer itemTransformer = new ItemTransformer();
    Money money = new Money(1, 50);
    BigDecimal expected = new BigDecimal(1.50);

    assertThat(itemTransformer.toBigDecimal(money))
        .isEqualTo(expected);
  }

    @Test
  void transformsFruitItemToFruitDbo() {
    ItemTransformer itemTransformer = new ItemTransformer();
    BigDecimal price = new BigDecimal(1.99);
    BigDecimal weight = new BigDecimal(0.2);
    Item item = new Item("Oranges", new Money(1, 99), weight, ItemType.FRUIT);

    ItemDbo expectedDbo = new ItemDbo();
    expectedDbo.setName("Oranges");
    expectedDbo.setPrice(price);
    expectedDbo.setWeight(weight);
    expectedDbo.setItemType(com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType.FRUIT);
    itemTransformer.toItemDbo(item);

  }
}
