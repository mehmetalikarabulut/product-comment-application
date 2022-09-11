package com.works.commentapplication.restcontrollers;

import com.works.commentapplication.entities.Product;
import com.works.commentapplication.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/expiredProductList")
    public ResponseEntity expiredProductList(@RequestParam String expirationDate) {
        return productService.expiredProductList(expirationDate);
    }

    @GetMapping("/notExpiredProductList")
    public ResponseEntity notExpiredProductList(@RequestParam String expirationDate) {
        return productService.notExpiredProductList(expirationDate);
    }
}
