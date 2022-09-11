package com.works.commentapplication.restcontrollers;

import com.works.commentapplication.entities.ProductComment;
import com.works.commentapplication.services.ProductCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comments")
public class ProductCommentRestController {
    final ProductCommentService productCommentService;

    public ProductCommentRestController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody ProductComment productComment) {
        return productCommentService.save(productComment);
    }

    @GetMapping("/list/{productId}")
    public ResponseEntity listComments(@PathVariable Integer productId) {
        return productCommentService.listComments(productId);
    }

    @GetMapping("/getCommentByDate")
    public ResponseEntity getCommentByDate(@RequestParam String startDate, @RequestParam String endDate){
        return productCommentService.getCommentByDate(startDate, endDate);
    }

    @GetMapping("/listCommentByUser/{id}")
    public ResponseEntity listCommentByUser(@PathVariable Integer id) {
        return productCommentService.listCommentByUser(id);
    }
}
