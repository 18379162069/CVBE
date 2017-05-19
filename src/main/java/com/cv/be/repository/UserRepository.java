package com.cv.be.repository;

import com.cv.be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zhou_wb on 2017/5/19.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
