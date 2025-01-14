package com.tiendarefrescos.backend.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

    @Entity
    @Table(name = "SODAPRODUCTS")
    public class sodaProduct {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "PRODUCT_ID")
        private Long id;
    
        @Column(name = "NAME", nullable = false)
        private String name;
    
        @Column(name = "PRICE", nullable = false)
        private BigDecimal price;
    
        @Column(name = "STOCK", nullable = true) // Opcional según el nivel de control requerido
        private Integer stock;
    
        // Getters y Setters
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public BigDecimal getPrice() {
            return price;
        }
    
        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    
        public Integer getStock() {
            return stock;
        }
    
        public void setStock(Integer stock) {
            this.stock = stock;
        }
    }