package com.cv.be.controller.cv;

import com.cv.be.entity.CV;
import com.cv.be.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by zhou_wb on 2017/5/18.
 */
@Controller
public class CVCommand {

    @Autowired
    CVService cvService;

    @PostMapping("cv")
    ResponseEntity<HttpStatus> add(@RequestBody CV cv){
        CV cv1 = null;
        if (cv != null){
             cv1 = cvService.add(cv);
        }
        if (cv1 == null){
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        } else {
            return ResponseEntity.ok(HttpStatus.OK);
        }

    }

}
