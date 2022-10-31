package com.tomspencerlondon.supermarket;

import com.tomspencerlondon.supermarket.adapter.out.jpa.ItemJpaRepository;
import com.tomspencerlondon.supermarket.adapter.out.jpa.ItemRepositoryJpaAdapter;
import com.tomspencerlondon.supermarket.adapter.out.jpa.ItemTransformer;
import com.tomspencerlondon.supermarket.hexagon.application.BasketService;
import com.tomspencerlondon.supermarket.hexagon.application.port.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SuperMarketApplication {
  public static void main(String[] args) {
    SpringApplication.run(SuperMarketApplication.class, args);
  }

  @Bean
  public BasketService basketService() {
    return new BasketService();
  }
}
