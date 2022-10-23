package com.tomspencerlondon.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.hexagon.domain.Product;
import com.tomspencerlondon.hexagon.domain.ProductId;
import org.junit.jupiter.api.Test;

public class CartServiceTest {

  @Test
  void emptyCartHasPriceZero() {
    CartService cartService = new CartService();

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(0);
  }

  @Test
  void cartWithOneItemHasPriceForOneItem() {
    CartService cartService = new CartService();

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(0.50);
  }

  @Test
  void cartWithTwoProductsHasPriceForTwoItems() {
    CartService cartService = new CartService();

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50));
    cartService.add(new Product(ProductId.of(2L), "Beans", 0.50));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.00);
  }

  @Test
  void cartWithThreeCansOfBeansCostsSameAsPriceForTwo() {
    CartService cartService = new CartService();

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50));
    cartService.add(new Product(ProductId.of(2L), "Beans", 0.50));
    cartService.add(new Product(ProductId.of(3L), "Beans", 0.50));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.00);
  }
}
