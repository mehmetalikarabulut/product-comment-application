package com.works.commentapplication.services;

import com.works.commentapplication.entities.Product;
import com.works.commentapplication.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity save(Product product) {
        Map<String, Object> hm = new HashMap<>();
        Product p = productRepository.save(product);
        hm.put("product", product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity expiredProductList(String expirationDate) {
        Map<String, Object> hm = new HashMap<>();
        Date expiredDate = null;
        try {
            expiredDate = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);
        } catch (Exception ex) {

        }
        List<Product> list = productRepository.findByExpirationDateLessThan(expiredDate);
        hm.put("status", true);
        hm.put("products", list);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity notExpiredProductList(String expirationDate) {
        Map<String, Object> hm = new HashMap<>();
        Date expiredDate = null;
        try {
            expiredDate = new SimpleDateFormat("yyyy-MM-dd").parse(expirationDate);
        } catch (Exception ex) {

        }
        List<Product> list = productRepository.findByExpirationDateGreaterThanOrExpirationDateNull(expiredDate);
        hm.put("status", true);
        hm.put("products", list);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }
}
