package com.tomspencerlondon.hexagon.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.hexagon.application.port.InMemorySupermarketRepository;
import com.tomspencerlondon.hexagon.application.port.SupermarketRepository;
import com.tomspencerlondon.hexagon.domain.Product;
import com.tomspencerlondon.hexagon.domain.ProductId;
import org.junit.jupiter.api.Test;

public class SupermarketServiceTest {

  @Test
  void addProductIncreasesAvailableProducts() {
    SupermarketRepository repository = new InMemorySupermarketRepository();
    SupermarketService supermarketService = new SupermarketService(repository);
    double productPrice = 0.50;
    String productName = "Beans";
    Product product = new Product(ProductId.of(1L), productName, productPrice);
    supermarketService.add(product);

    assertThat(supermarketService.contents())
        .containsExactly(product);
  }
}
