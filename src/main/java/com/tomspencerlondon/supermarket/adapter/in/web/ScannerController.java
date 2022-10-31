package com.tomspencerlondon.supermarket.adapter.in.web;

import com.tomspencerlondon.supermarket.hexagon.application.BasketService;
import com.tomspencerlondon.supermarket.hexagon.application.port.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScannerController {

  private final BasketService basketService;
  private ItemRepository itemRepository;

  @Autowired
  public ScannerController(BasketService basketService, ItemRepository itemRepository) {
    this.basketService = basketService;
    this.itemRepository = itemRepository;
  }

  @GetMapping("/")
  public String scanItem(Model model) {
    model.addAttribute("itemName", "");
    MoneyDto total = MoneyDto.from(basketService.total());
    model.addAttribute("total", total.asString());
    return "scan";
  }

//  @PostMapping("/")
//  public String addItem(@RequestParam(name = "itemName", defaultValue = "") String itemName) {
//    basketService.add(new Item(itemName, ));
//  }

}
