package com.iventory.app.Controllers;
import org.springframework.web.bind.annotation.RestController;

import com.iventory.app.Models.ApiResponse;
import com.iventory.app.Models.Inventory;
import com.iventory.app.Services.IventoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/inventory")
@Tag(name = "Inventory Search", description = "Inventory Search Operations")
public class IventoryController {
    
    @Autowired
    private IventoryService _service;

    @GetMapping
    @Operation(summary = "Get inventory", description = "Get all inventories")
    public ApiResponse<List<Inventory>> getAllInventories() {
        List<Inventory> list = _service.getInventorys();
        ApiResponse<List<Inventory>> response = new ApiResponse<>(
            "success",
            list,
            "List of inventories"
        );
        return response;
    }

    @GetMapping("/searchInventoryByCodice/search")
    @Operation(summary = "Search inventory by code", description = "Search inventory by code")
    public ApiResponse<List<Inventory>> searchInventoryByCodice(@RequestParam String codice) {
        List<Inventory> list = _service.searchByCodice(codice);
        ApiResponse<List<Inventory>> response = new ApiResponse<>(
            "success", 
            list, 
            "List of inventories"
        );
        return response;
    }

}
