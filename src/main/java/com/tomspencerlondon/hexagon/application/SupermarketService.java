package com.tomspencerlondon.hexagon.application;

import com.tomspencerlondon.hexagon.application.port.SupermarketRepository;
import com.tomspencerlondon.hexagon.domain.Product;
import java.util.List;

public class SupermarketService {

  private SupermarketRepository repository;

  public SupermarketService(SupermarketRepository repository) {
    this.repository = repository;
  }

  public void add(Product product) {
    repository.save(product);
  }

  public List<Product> contents() {
    return repository.findAll();
  }
}
