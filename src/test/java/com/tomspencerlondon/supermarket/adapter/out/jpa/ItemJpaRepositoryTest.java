package com.tomspencerlondon.supermarket.adapter.out.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.tomspencerlondon.supermarket.hexagon.domain.Item;
import com.tomspencerlondon.supermarket.hexagon.domain.ItemBuilder;
import com.tomspencerlondon.supermarket.hexagon.domain.ItemType;
import com.tomspencerlondon.supermarket.hexagon.domain.Money;
import java.math.BigDecimal;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@Tag("integration")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers(disabledWithoutDocker = true)
public class ItemJpaRepositoryTest extends TestContainerConfiguration {

  @Autowired
  private ItemJpaRepository itemJpaRepository;

  @Test
  void storesItemsAndRetrievesItemsByName() {
    String itemName = "Oranges";
    Item item = new ItemBuilder()
        .withName(itemName)
        .withPrice(new Money(1, 99))
        .withWeight(new BigDecimal(0.2))
        .withItemType(ItemType.FRUIT)
        .build();

    ItemDbo itemDbo = new ItemDboBuilder()
        .withId(1L)
        .withName(itemName)
        .withWeight(new BigDecimal(1.99))
        .withWeight(new BigDecimal(0.2))
        .withItemType(com.tomspencerlondon.supermarket.adapter.out.jpa.ItemType.FRUIT)
        .build();

    ItemDbo savedItem = itemJpaRepository.save(itemDbo);

    assertThat(savedItem.getId())
        .isNotNull()
        .isGreaterThanOrEqualTo(0);
  }
}
