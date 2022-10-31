package com.tomspencerlondon.supermarket.adapter.in.web;

import javax.validation.constraints.NotNull;

public class CreateItemParameters {

  @NotNull
  private String name;
  @NotNull
  private String weight;
  @NotNull
  private String price;
  @NotNull
  private String itemType;

  public CreateItemParameters() {
  }

  public CreateItemParameters(String name, String weight, String price, String itemType) {
    this.name = name;
    this.weight = weight;
    this.price = price;
    this.itemType = itemType;
  }

  public String getName() {
    return name;
  }

  public String getWeight() {
    return weight;
  }

  public String getPrice() {
    return price;
  }

  public String getItemType() {
    return itemType;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }
}
