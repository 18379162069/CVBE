package com.cv.be.service;

import com.cv.be.entity.User;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/19.
 */
public interface UserService {
    /**
     * 删除用户
     */
    void delete(User user);

    /**
     * 修改用户登录状态
     */
    User locked(Integer userId, Boolean bool);

    /**
     * 修改用户密码
     */
    User modifyPwd(Integer userId,String pwd);

    /**
     * 查询所有用户信息
     */
    List<User> getUsers(PageRequest pageRequest);
}
