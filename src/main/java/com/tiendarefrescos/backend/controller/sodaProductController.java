package com.tiendarefrescos.backend.controller;

import com.tiendarefrescos.backend.model.sodaProduct;
import com.tiendarefrescos.backend.service.sodaProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sodas")
public class sodaProductController {

    @Autowired
    private sodaProductService sodaService;
    // lista.
    @GetMapping
    public List<sodaProduct> getAllSodas() {
        return sodaService.getAllSodas(); // Llama al servicio y retorna la lista de productos
    }

    @GetMapping("/{id}")
    public ResponseEntity<sodaProduct> getSodaById(@PathVariable Long id) {
        return sodaService.getSodaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public sodaProduct createSoda(@RequestBody sodaProduct sodaProduct) {
        return sodaService.saveSoda(sodaProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<sodaProduct> updateSoda(@PathVariable Long id, @RequestBody sodaProduct sodaDetails) {
        return sodaService.getSodaById(id)
                .map(existingSoda -> {
                    existingSoda.setName(sodaDetails.getName());
                    existingSoda.setPrice(sodaDetails.getPrice());
                    existingSoda.setStock(sodaDetails.getStock());
                    return ResponseEntity.ok(sodaService.saveSoda(existingSoda));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSoda(@PathVariable Long id) {
        if (sodaService.getSodaById(id).isPresent()) {
            sodaService.deleteSoda(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
