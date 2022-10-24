package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.domain.Item;
import com.tomspencerlondon.hexagon.domain.Order;

public class CartService {
  private Order pricer;

  public CartService(Order pricer) {
    this.pricer = pricer;
  }

  public double totalPrice() {
    return pricer.sum();
  }

  public void add(Item item) {
    pricer.add(item);
  }

}
