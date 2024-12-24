package com.mis.mis_web_app_api.modules.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
    Optional<Product> findByProductName(String name);
}
