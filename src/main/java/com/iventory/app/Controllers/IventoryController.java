package com.iventory.app.Controllers;
import org.springframework.web.bind.annotation.RestController;

import com.iventory.app.Models.ApiResponse;
import com.iventory.app.Models.Inventory;
import com.iventory.app.Services.IventoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/inventory")
public class IventoryController {
    
    @Autowired
    private IventoryService _service;

    @GetMapping
    public ApiResponse<List<Inventory>> getAllInventories() {
        List<Inventory> list = _service.getInventorys();
        ApiResponse<List<Inventory>> response = new ApiResponse<>(
            "success",
            list,
            "Lista de inventarios"
        );
        return response;
    }

    @GetMapping("/searchInventoryByCodice/search")
    public ApiResponse<List<Inventory>> searchInventoryByCodice(@RequestParam String codice) {
        List<Inventory> list = _service.searchByCodice(codice);
        ApiResponse<List<Inventory>> response = new ApiResponse<>(
            "success", 
            list, 
            "Lista de inventarios"
        );
        return response;
    }

}
