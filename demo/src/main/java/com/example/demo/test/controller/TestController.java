package com.example.demo.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @program: demo
 * @description: 项目测试controller
 * @author: songzm
 * @create: 2020-01-07 09:20
 **/
@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {
    /**
     * 文件上传解析方法
     * @param file
     */
    @PostMapping("/uploadFile")
    public Map<String,Object> importFile(MultipartFile file,String out_id){
        String pathName = "D:/dmpFile/";
        String fullFileName = pathName + UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        FileOutputStream fos = null;
        Map<String,Object> result=new HashMap<>();
        try {
            fos=new FileOutputStream(fullFileName);
            fos.write(file.getBytes());
            System.out.println("上传的文件内容："+new String(file.getBytes(),"utf-8"));
            result.put("code",200);
            result.put("masssage","上传成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
