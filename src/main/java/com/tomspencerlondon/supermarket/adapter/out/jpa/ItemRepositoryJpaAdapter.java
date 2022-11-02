package com.tomspencerlondon.supermarket.adapter.out.jpa;

import com.tomspencerlondon.supermarket.hexagon.application.port.ItemRepository;
import com.tomspencerlondon.supermarket.hexagon.domain.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemRepositoryJpaAdapter implements ItemRepository {

  private final ItemJpaRepository itemJpaRepository;
  private final ItemTransformer itemTransformer;

  @Autowired
  public ItemRepositoryJpaAdapter(ItemJpaRepository itemJpaRepository, ItemTransformer itemTransformer) {
    this.itemJpaRepository = itemJpaRepository;
    this.itemTransformer = itemTransformer;
  }

  @Override
  public Item save(Item item) {
    ItemDbo itemDbo = itemTransformer.toItemDbo(item);
    return itemTransformer.toItem(itemJpaRepository.save(itemDbo));
  }

  @Override
  public List<Item> findAll() {
    List<ItemDbo> items = itemJpaRepository.findAll();

    return items
        .stream()
        .map(itemTransformer::toItem)
        .toList();
  }

  @Override
  public Optional<Item> findByName(String itemName) {
    return itemJpaRepository
        .findByItemName(itemName)
        .map(itemTransformer::toItem);
  }
}
