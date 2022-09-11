package com.works.commentapplication.services;

import com.works.commentapplication.entities.ProductComment;
import com.works.commentapplication.entities.User;
import com.works.commentapplication.repositories.ProductCommentRepository;
import com.works.commentapplication.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProductCommentService {
    final UserRepository userRepository;
    final ProductCommentRepository productCommentRepository;

    public ProductCommentService(UserRepository userRepository, ProductCommentRepository productCommentRepository) {
        this.userRepository = userRepository;
        this.productCommentRepository = productCommentRepository;
    }

    public ResponseEntity save(ProductComment productComment) {
        Map<String, Object> hm = new HashMap<>();
        ProductComment p = productCommentRepository.save(productComment);
        hm.put("product", productComment);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity listComments(Integer productId) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<ProductComment> ls = productCommentRepository.findByProduct_Id(productId);
        hm.put("searchTotal", ls.size());
        hm.put("status", true);
        hm.put("comments", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getCommentByDate(String startDate, String endDate){
        Map<String, Object> hm = new LinkedHashMap<>();
        Date startedDate = null;
        Date endedDate = null;
        try {
            startedDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            endedDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        } catch (Exception ex) {

        }
        List<ProductComment> comments = productCommentRepository.findByCreatedTimeBetween(startedDate, endedDate);
        hm.put("status", true);
        hm.put("comments", comments);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity listCommentByUser(Integer userId) {
        Map<String, Object> hm = new HashMap<>();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()){
            List<ProductComment> ls = productCommentRepository.findByUser_Id(userId);
            hm.put("status", true);
            hm.put("comments", ls);
        }else {
            hm.put("status", false);
            hm.put("result", "Empty!" );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
