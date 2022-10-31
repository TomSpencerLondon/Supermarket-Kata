package com.tomspencerlondon.supermarket.adapter.in.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tomspencerlondon.supermarket.hexagon.application.port.ItemRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@Tag("integration")
@WebMvcTest
class ScannerWebMvcTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ItemRepository itemRepository;


  @Test
  void getRootPathIs200Ok() throws Exception {
    mockMvc.perform(get("/"))
        .andExpect(status().isOk());
  }

  @Test
  @Disabled
  void postToRootPathIsRedirect() throws Exception {
    mockMvc.perform(post("/")
            .param("itemName", "Oranges")
        )
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/"));
  }
}