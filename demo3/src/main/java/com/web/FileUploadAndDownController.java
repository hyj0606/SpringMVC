package com.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName FileUploadAndDownController
 * @Description TODO
 * @Author hyj98
 * @Date 2022-11-22 11:33
 * @Version 1.0
 */
@Controller
public class FileUploadAndDownController {

    @RequestMapping("/upload")
    public String t1(ModelMap mm, String account, MultipartFile myPic) throws IOException {

        System.out.println("模拟解析普通字段: " + account);

        //存储上传文件到磁盘中:
        String parent = "d:/image/";
        Random random = new Random();

        int i = random.nextInt(99999);

        String fileName = myPic.getOriginalFilename();
        String houzhui = fileName.substring(fileName.lastIndexOf("."));
        String new_file = i+houzhui;

        myPic.transferTo(new File(parent+new_file));

        mm.addAttribute("file_path",new_file);

        return "down.jsp";
    }

    @RequestMapping("/down2")
    public ResponseEntity t2( String file ) throws IOException {

        //三个参数: T  : 响应主体.  MultiValueMap: 响应头设置.  HttpStatus:状态码.
        String parent = "d:/image/";
        FileInputStream fis = new FileInputStream(new File(parent+file));
        byte[] bs = new byte[fis.available()];
        fis.read(bs);
        fis.close();

        MultiValueMap multiValueMap = new HttpHeaders();
        multiValueMap.add("Content-Disposition", "attachment;filename="+file);

        ResponseEntity entity = new ResponseEntity(bs, multiValueMap, HttpStatus.OK);

        return entity;
    }

}
