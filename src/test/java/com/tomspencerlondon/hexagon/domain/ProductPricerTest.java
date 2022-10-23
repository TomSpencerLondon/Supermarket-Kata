package com.tomspencerlondon.hexagon.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductPricerTest {

  @Test
  void pricesThreeBeansForTwo() {
    ProductPricer pricer = new ProductPricer();
    pricer.add(new Product(ProductId.of(1L), "Beans", 0.50, 0));
    pricer.add(new Product(ProductId.of(2L), "Beans", 0.50, 0));
    pricer.add(new Product(ProductId.of(3L), "Beans", 0.50, 0));

    assertThat(pricer.sum())
        .isEqualTo(1.0);
  }

  @Test
  void twoCansOfCokeForOnePound() {
    ProductPricer pricer = new ProductPricer();
    pricer.add(new Product(ProductId.of(1L), "Coke", 0.70, 0));
    pricer.add(new Product(ProductId.of(2L), "Coke", 0.70, 0));

    assertThat(pricer.sum())
        .isEqualTo(1.0);
  }

  @Test
  void TwoHundredGramsOrangesCost40pence() {
    ProductPricer pricer = new ProductPricer();
    pricer.add(new Product(ProductId.of(1L), "Oranges", 1.99, 0.2));

    assertThat(pricer.sum())
        .isEqualTo(0.40);
  }
}