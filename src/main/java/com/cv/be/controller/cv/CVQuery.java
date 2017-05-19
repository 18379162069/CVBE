package com.cv.be.controller.cv;

import com.cv.be.entity.CV;
import com.cv.be.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhou_wb on 2017/5/19.
 */
@Controller
public class CVQuery {
    @Autowired
    private CVService cvService;

    @GetMapping("/cvs")
    @ResponseBody

    public List<CV> getCVList(){
        PageRequest pageRequest = new PageRequest(0,10);
        return cvService.findAll(pageRequest);
    }


    @GetMapping("/cvs/{id}")
    ResponseEntity<CV>  getCV(@PathVariable Integer id){
        CV cv = cvService.getOne(id);
        return ResponseEntity.ok(cv);
    }

}
