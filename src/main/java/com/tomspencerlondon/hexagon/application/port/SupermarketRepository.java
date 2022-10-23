package com.tomspencerlondon.hexagon.application.port;

import com.tomspencerlondon.hexagon.domain.Product;
import com.tomspencerlondon.hexagon.domain.ProductId;
import java.util.List;
import java.util.Optional;

public interface SupermarketRepository {
  Optional<Product> findById(ProductId productId);

  Product save(Product product);

  List<Product> findAll();
}
