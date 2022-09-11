package com.works.commentapplication.restcontrollers;

import com.works.commentapplication.entities.User;
import com.works.commentapplication.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {
    final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user) {
        return userService.save(user);
    }
}
