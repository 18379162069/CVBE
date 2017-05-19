package com.cv.be.service;

import com.cv.be.entity.CV;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by zhou_wb on 2017/5/18.
 */
public interface CVService {
    /**
     * 添加简历模板
     */
    CV add(CV cv);

    /**
     * 删除简历模板
     */
    CV delete(CV cv);

    /**
     * 获取总的简历模板
     */
    List<CV> findAll(Pageable pageable);

    /**
     * 更新简历模板
     */
    CV update(CV cv);


    /**
     * 根据id获取简历模板
     */
    CV getOne(Integer id);
}
