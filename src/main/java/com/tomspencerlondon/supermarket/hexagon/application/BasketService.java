package com.tomspencerlondon.supermarket.hexagon.application;

import com.tomspencerlondon.supermarket.hexagon.domain.Basket;
import com.tomspencerlondon.supermarket.hexagon.domain.Item;
import com.tomspencerlondon.supermarket.hexagon.domain.Money;
import com.tomspencerlondon.supermarket.hexagon.domain.Receipt;
import java.util.List;


public class BasketService {
  Basket basket = new Basket(new Receipt(new Money(0, 0), new Money(0, 0)));

  public void add(Item item) {
    basket.add(item);
  }

  public List<Item> items() {
    return basket.items();
  }

  public Receipt receipt() {
    return basket.receipt();
  }

  public Money total() {
    return basket.totalToPay();
  }
}
