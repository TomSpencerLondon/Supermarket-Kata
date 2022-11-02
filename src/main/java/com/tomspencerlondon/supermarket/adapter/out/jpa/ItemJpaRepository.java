package com.tomspencerlondon.supermarket.adapter.out.jpa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<ItemDbo, Long> {
  Optional<ItemDbo> findByItemName(String itemName);
}
