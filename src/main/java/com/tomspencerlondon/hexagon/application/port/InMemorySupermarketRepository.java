package com.tomspencerlondon.hexagon.application.port;

import com.tomspencerlondon.hexagon.domain.Product;
import com.tomspencerlondon.hexagon.domain.ProductId;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemorySupermarketRepository implements SupermarketRepository {
  private final Map<ProductId, Product> products = new ConcurrentHashMap<>();
  private final AtomicLong sequence = new AtomicLong(1);
  private int saveCount = 0;

  @Override
  public Optional<Product> findById(ProductId productId) {
    return Optional.empty();
  }

  @Override
  public Product save(Product product) {
    if (product.getId() == null) {
      product.setId(ProductId.of(sequence.getAndIncrement()));
    }

    products.put(product.getId(), product);
    saveCount++;
    return product;
  }

  @Override
  public List<Product> findAll() {
    return List.copyOf(products.values());
  }
}
