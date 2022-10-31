package com.tomspencerlondon.supermarket.adapter.out.jpa;

import com.tomspencerlondon.supermarket.hexagon.domain.Item;
import com.tomspencerlondon.supermarket.hexagon.domain.ItemId;
import com.tomspencerlondon.supermarket.hexagon.domain.ItemType;
import com.tomspencerlondon.supermarket.hexagon.domain.Money;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

@Service("jpaItemTransformer")
public class ItemTransformer {

  Item toItem(ItemDbo itemDbo) {
    return new Item(ItemId.of(itemDbo.getId()), itemDbo.getName(),
        Money.toMoney(itemDbo.getPrice()),
        itemDbo.getWeight(),
        toItemType(itemDbo.getItemType()));
  }

  public ItemDbo toItemDbo(Item item) {
    ItemDbo itemDbo = new ItemDbo();
    itemDbo.setName(item.name());
    itemDbo.setPrice(toBigDecimal(item.price()));
    itemDbo.setWeight(item.weight());
    itemDbo.setItemType(fromItemType(item.itemType()));
    return itemDbo;
  }

  private com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType fromItemType(ItemType itemType) {
    if (itemType == ItemType.FRUIT) {
      return com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType.FRUIT;
    }
    return com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType.NORMAL;
  }

  private ItemType toItemType(com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType itemType) {
    if (itemType == com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType.FRUIT) {
      return ItemType.FRUIT;
    }
    return ItemType.NORMAL;
  }

  BigDecimal toBigDecimal(Money money) {
    BigDecimal pounds = BigDecimal.valueOf(money.pounds());
    BigDecimal pence = BigDecimal.valueOf(money.pence()).divide(BigDecimal.valueOf(100), 1, RoundingMode.HALF_UP);
    return pounds.add(pence);
  }
}
