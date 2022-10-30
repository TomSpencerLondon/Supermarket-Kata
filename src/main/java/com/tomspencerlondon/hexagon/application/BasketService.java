package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.domain.Basket;
import com.tomspencerlondon.hexagon.domain.Item;
import com.tomspencerlondon.hexagon.domain.Money;
import com.tomspencerlondon.hexagon.domain.Pricer;

public class BasketService {
  Basket basket = new Basket(new Pricer(new Money(0, 0), new Money(0, 0)));

  public void add(Item item) {
    basket.add(item);
  }


}
