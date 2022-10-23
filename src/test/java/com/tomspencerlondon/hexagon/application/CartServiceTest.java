package com.tomspencerlondon.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.hexagon.domain.Product;
import com.tomspencerlondon.hexagon.domain.ProductId;
import com.tomspencerlondon.hexagon.domain.ProductPricer;
import org.junit.jupiter.api.Test;

public class CartServiceTest {

  @Test
  void emptyCartHasPriceZero() {
    ProductPricer pricer = new ProductPricer();
    CartService cartService = new CartService(pricer);

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(0);
  }

  @Test
  void cartWithOneItemHasPriceForOneItem() {
    ProductPricer pricer = new ProductPricer();
    CartService cartService = new CartService(pricer);

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(0.50);
  }

  @Test
  void cartWithTwoProductsHasPriceForTwoItems() {
    ProductPricer pricer = new ProductPricer();
    CartService cartService = new CartService(pricer);

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(2L), "Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.00);
  }

  @Test
  void cartWithThreeCansOfBeansCostsSameAsPriceForTwo() {
    ProductPricer pricer = new ProductPricer();
    CartService cartService = new CartService(pricer);

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(2L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(3L), "Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.00);
  }

  @Test
  void cartWithFourCansOfBeansCostsSameAsPriceForThree() {
    ProductPricer pricer = new ProductPricer();
    CartService cartService = new CartService(pricer);

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(2L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(3L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(4L), "Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(1.50);
  }

  @Test
  void cartWithSixCansOfBeansCostsSameAsPriceForFour() {
    ProductPricer pricer = new ProductPricer();
    CartService cartService = new CartService(pricer);

    cartService.add(new Product(ProductId.of(1L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(2L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(3L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(4L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(5L), "Beans", 0.50, 0));
    cartService.add(new Product(ProductId.of(6L), "Beans", 0.50, 0));

    double totalPrice = cartService.totalPrice();

    assertThat(totalPrice)
        .isEqualTo(2.00);
  }
}
