package com.tomspencerlondon.supermarket.adapter.out.jpa;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers(disabledWithoutDocker = true)
public abstract class TestContainerConfiguration {
  static final PostgreSQLContainer postgresContainer;

  static {
    postgresContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:14"))
        .withDatabaseName("test")
        .withUsername("duke")
        .withPassword("s3cret");
    postgresContainer.start();
  }

  @DynamicPropertySource
  static void properties(DynamicPropertyRegistry registry) {
    registry.add("spring.sql.init.platform", () -> "postgresql");
    registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
    registry.add("spring.datasource.password", postgresContainer::getPassword);
    registry.add("spring.datasource.username", postgresContainer::getUsername);
    registry.add("questions.basenumberofchoices", () -> 4);
  }
}
