package com.cv.be.controller.user;

import com.cv.be.entity.User;
import com.cv.be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zhou_wb on 2017/5/19.
 */
@Controller
public class UserCommand {

    @Autowired
    private UserService userService;

    /**
     * 锁定/解锁用户
     * @param userId
     * @param status
     * @return
     */
    @PutMapping("/users/{userId}/islocked")
    ResponseEntity<HttpStatus> lockedUser(@PathVariable Integer userId,@RequestParam Boolean status){
        User user = userService.locked(userId,status);
        if (user != null){
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/users/{userId}/pwd")
    ResponseEntity<HttpStatus> modifyPwd(@PathVariable Integer userId,@RequestParam String pwd){
        User user = userService.modifyPwd(userId, pwd);
        if (user != null){
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
    }

}
