package com.iventory.app.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iventory.app.Models.Inventory;

public interface IventoryRepository extends JpaRepository<Inventory, Integer>{
    List<Inventory> findByEstadoTrue();
    
    @Query("SELECT i FROM Inventory i WHERE i.estado = true AND (LOWER(i.codigoProducto) LIKE LOWER(CONCAT('%', :codice, '%')) OR LOWER(i.codigoInventario) LIKE LOWER(CONCAT('%', :codice, '%'))) ")
    List<Inventory> findByCodice(@Param("codice") String codice);
}
