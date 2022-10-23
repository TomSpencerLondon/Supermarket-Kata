package com.tomspencerlondon.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CartServiceTest {

  @Test
  void emptyCartHasPriceZero() {
    CartService cartService = new CartService();

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(0);
  }
}
