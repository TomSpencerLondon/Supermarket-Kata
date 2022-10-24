package com.tomspencerlondon.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.hexagon.domain.Item;
import com.tomspencerlondon.hexagon.domain.Order;
import org.junit.jupiter.api.Test;

public class CartServiceTest {

  @Test
  void emptyCartHasPriceZero() {
    Order order = new Order();
    CartService cartService = new CartService(order);

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(0);
  }

  @Test
  void cartWithOneItemHasPriceForOneItem() {
    Order order = new Order();
    CartService cartService = new CartService(order);

    cartService.add(new Item("Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(0.50);
  }

  @Test
  void cartWithTwoProductsHasPriceForTwoItems() {
    Order order = new Order();
    CartService cartService = new CartService(order);

    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.00);
  }

  @Test
  void cartWithThreeCansOfBeansCostsSameAsPriceForTwo() {
    Order order = new Order();
    CartService cartService = new CartService(order);

    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.00);
  }

  @Test
  void cartWithFourCansOfBeansCostsSameAsPriceForThree() {
    Order order = new Order();
    CartService cartService = new CartService(order);

    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.50);
  }

  @Test
  void cartWithSixCansOfBeansCostsSameAsPriceForFour() {
    Order order = new Order();
    CartService cartService = new CartService(order);

    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));
    cartService.add(new Item("Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(2.00);
  }
}
