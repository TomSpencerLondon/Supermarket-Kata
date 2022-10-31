package com.tomspencerlondon.supermarket.adapter.in.web;

import com.tomspencerlondon.supermarket.hexagon.application.port.ItemRepository;
import com.tomspencerlondon.supermarket.hexagon.domain.ItemType;
import com.tomspencerlondon.supermarket.hexagon.domain.Money;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {


  private ItemRepository itemRepository;

  @Autowired
  public ItemRestController(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }


  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public ItemDto createItem(@RequestBody CreateItemParameters parameters) {
    return ItemDto.from(
        parameters.getName(),
        MoneyDto.from(Money.toMoney(new BigDecimal(parameters.getPrice()))),
        WeightDto.toWeightDto(new BigDecimal(parameters.getWeight())),
        ItemType.from(parameters.getItemType())
    );
  }

}
