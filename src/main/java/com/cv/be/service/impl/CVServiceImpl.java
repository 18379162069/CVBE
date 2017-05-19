package com.cv.be.service.impl;

import com.cv.be.entity.CV;
import com.cv.be.repository.CVRepository;
import com.cv.be.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
@Service("cvService")
public class CVServiceImpl implements CVService{

    @Autowired
    CVRepository cvRepository;
    @Override
    public CV add(CV cv) {
        if (cv != null){
            cvRepository.save(cv);
        }
        return cv;
    }

    @Override
    public CV delete(CV cv) {
        cvRepository.delete(cv);
        return null;
    }

    @Override
    public List<CV> findAll(Pageable pageable) {
        Page<CV> page = cvRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public CV update(CV cv) {
        CV cv1 = cvRepository.findById(cv.getId());
        if (cv1 != null){
            cv.setBasicInfo(cv1.getBasicInfo());
            cv.setCvItrams(cv1.getCvItrams());
            cv.setAddQuiz(cv1.getAddQuiz());
            cv = cvRepository.save(cv);
        }
        return cv;
    }

    @Override
    public CV getOne(Integer id) {
        return cvRepository.findById(id);
    }
}
