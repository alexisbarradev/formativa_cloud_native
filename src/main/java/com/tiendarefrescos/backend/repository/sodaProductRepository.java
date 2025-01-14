package com.tiendarefrescos.backend.repository;

import com.tiendarefrescos.backend.model.sodaProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sodaProductRepository extends JpaRepository<sodaProduct, Long> {
}