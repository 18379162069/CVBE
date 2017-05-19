package com.cv.be.service.impl;

import com.cv.be.entity.User;
import com.cv.be.repository.UserRepository;
import com.cv.be.service.UserService;
import com.cv.be.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public User locked(Integer userId, Boolean bool) {
        User user = userRepository.findOne(userId);
        if (user != null){
            user.setIsLocked(bool);
            user = userRepository.save(user);
        }
        return user;
    }

    @Override
    public User modifyPwd(Integer userId, String pwd) {
        User user = userRepository.findOne(userId);
        if (user != null){
            user.setPwd(CommonUtil.MD5Encr(pwd));
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public List<User> getUsers(PageRequest pageRequest) {

        return  userRepository.findAll(pageRequest).getContent();
    }
}
