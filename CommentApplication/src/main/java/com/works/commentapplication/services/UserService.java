package com.works.commentapplication.services;

import com.works.commentapplication.entities.User;
import com.works.commentapplication.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity save( User user) {
        Map<String, Object> hm = new HashMap<>();
        User u = userRepository.save(user);
        hm.put("user", user);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
