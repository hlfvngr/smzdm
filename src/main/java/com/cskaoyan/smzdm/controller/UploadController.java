package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.utils.AliyunUploadutils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    @RequestMapping("/uploadImage")
    @ResponseBody
    public Map<String,Object> updateImage(MultipartFile file){
        Map<String,Object> result = new HashMap<>();
        try {
            String uploadPath = AliyunUploadutils.upload(file);
            result.put("msg",uploadPath);
            result.put("code",0);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code",1);
        }
        return result;
    }
}
