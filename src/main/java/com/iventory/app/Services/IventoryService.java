package com.iventory.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iventory.app.Models.Inventory;
import com.iventory.app.Repository.IventoryRepository;

@Service
public class IventoryService {
    
    @Autowired
    private IventoryRepository _repository;

    public List<Inventory> getInventorys() {
        return _repository.findByStatusTrue();
    }

    public List<Inventory> searchByCodice(String codice) {
        return _repository.findByCodice(codice);
    }

}
