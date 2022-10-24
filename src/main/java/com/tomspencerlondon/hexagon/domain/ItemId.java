package com.tomspencerlondon.hexagon.domain;

public class ItemId {

  private Long id;

  public ItemId(Long id) {
    this.id = id;
  }

  public static ItemId of(Long id) {
    return new ItemId(id);
  }

  public Long getId() {
    return id;
  }
}
