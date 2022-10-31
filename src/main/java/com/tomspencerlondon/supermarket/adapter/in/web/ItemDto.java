package com.tomspencerlondon.supermarket.adapter.in.web;

import com.tomspencerlondon.supermarket.hexagon.domain.ItemType;

public class ItemDto {
  private String name;
  private final String price;
  private final String weight;
  private ItemType itemType;

  public ItemDto(String name, String price, String weight, ItemType itemType) {
    this.name = name;
    this.price = price;
    this.weight = weight;
    this.itemType = itemType;
  }

  public static ItemDto from(String name, MoneyDto moneyDto, WeightDto weightDto, ItemType itemType) {
    return new ItemDto(name, moneyDto.asString(), weightDto.asString(), itemType);
  }

  public String getName() {
    return name;
  }

  public String getPrice() {
    return price;
  }

  public String getWeight() {
    return weight;
  }

  public ItemType getItemType() {
    return itemType;
  }
}
