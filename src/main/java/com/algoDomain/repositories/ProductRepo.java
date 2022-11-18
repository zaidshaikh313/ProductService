package com.algoDomain.repositories;

import com.algoDomain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String productName);


    List<Product> findAllByInCart(Boolean val);
}
