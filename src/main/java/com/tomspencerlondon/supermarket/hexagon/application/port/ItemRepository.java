package com.tomspencerlondon.supermarket.hexagon.application.port;

import com.tomspencerlondon.supermarket.hexagon.domain.Item;
import java.util.List;
import java.util.Optional;

public interface ItemRepository {
  Item save(Item item);

  List<Item> findAll();

  Optional<Item> findByName(String itemName);
}
