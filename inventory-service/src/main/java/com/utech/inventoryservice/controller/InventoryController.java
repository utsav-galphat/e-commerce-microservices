package com.utech.inventoryservice.controller;

import com.utech.inventoryservice.dto.InventoryResponse;
import com.utech.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
