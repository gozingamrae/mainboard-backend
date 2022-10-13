package com.gozin.mainboard.inventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InventoryController {
    @GetMapping("inventorys")
    public String test(){
        return "hello";
    }

}
