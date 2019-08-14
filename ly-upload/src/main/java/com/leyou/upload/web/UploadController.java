package com.leyou.upload.web;

import com.leyou.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author tianwenwen
 * @date 2019/8/7 23:33
 **/
@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 功能描述:图片上传
     *
     * @return org.springframework.http.ResponseEntity<java.lang.String>
     * @Author wenwen
     * @Description //TODO
     * @Date 2019/8/7 23:37
     * @Param [file]
     **/
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file")
                                                      MultipartFile file) throws IOException {

        return ResponseEntity.ok(uploadService.uploadImage(file));
    }
    @GetMapping("image")
    public String test1(){
        return "hello";
    }
}
