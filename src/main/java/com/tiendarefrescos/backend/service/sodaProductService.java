package com.tiendarefrescos.backend.service;
import com.tiendarefrescos.backend.model.sodaProduct;
import com.tiendarefrescos.backend.repository.sodaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class sodaProductService {

    @Autowired
    private sodaProductRepository sodaProductRepository;

    // Obtener todos los productos de soda
    public List<sodaProduct> getAllSodas() {
        return sodaProductRepository.findAll();
    }

    // Obtener un producto de soda por ID
    public Optional<sodaProduct> getSodaById(Long id) {
        return sodaProductRepository.findById(id);
    }

    // Guardar o actualizar un producto de soda
    public sodaProduct saveSoda(sodaProduct sodaProduct) {
        return sodaProductRepository.save(sodaProduct);
    }

    // Eliminar un producto de soda por ID
    public void deleteSoda(Long id) {
        sodaProductRepository.deleteById(id);
    }
}
