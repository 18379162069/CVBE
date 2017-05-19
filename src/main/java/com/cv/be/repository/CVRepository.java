package com.cv.be.repository;

import com.cv.be.entity.CV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by zhou_wb on 2017/5/18.
 */
public interface CVRepository extends JpaRepository<CV, Integer> {

    /**
     * 查询所有简历模板
     */
    Page<CV> findAll(Pageable pageable);

    /**
     * 根据简历模板ID查询模板
     */
    CV findById(Integer id);
}
