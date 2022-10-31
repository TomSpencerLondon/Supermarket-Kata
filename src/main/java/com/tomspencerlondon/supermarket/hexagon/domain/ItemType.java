package com.tomspencerlondon.supermarket.hexagon.domain;

public enum ItemType {
  FRUIT, NORMAL;

  public static ItemType from(String itemType) {
    return "fruit".equals(itemType) ? FRUIT : NORMAL;
  }
}
