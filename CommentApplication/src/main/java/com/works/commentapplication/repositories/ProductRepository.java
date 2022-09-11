package com.works.commentapplication.repositories;

import com.works.commentapplication.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByExpirationDateLessThan(Date expirationDate);

    List<Product> findByExpirationDateGreaterThanOrExpirationDateNull(Date expirationDate);
}