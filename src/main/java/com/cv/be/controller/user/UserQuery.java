package com.cv.be.controller.user;

import com.cv.be.entity.User;
import com.cv.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/19.
 */
@Controller
public class UserQuery {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers(){
        PageRequest pageRequest = new PageRequest(0,10);
        List<User> users = userService.getUsers(pageRequest);
        return ResponseEntity.ok(users);
    }
}
