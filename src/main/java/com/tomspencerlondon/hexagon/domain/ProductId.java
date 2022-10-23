package com.tomspencerlondon.hexagon.domain;

public class ProductId {

  private Long id;

  public ProductId(Long id) {
    this.id = id;
  }

  public static ProductId of(Long id) {
    return new ProductId(id);
  }

  public Long getId() {
    return id;
  }
}
