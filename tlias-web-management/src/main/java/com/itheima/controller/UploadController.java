package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
/*    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("接收到的参数：{}，{}，{}", username, age, image);
        //将文件存储在磁盘目录当中D:\CodeLearning\Java\laji         getOriginalFilename()获取文件名
        //本地储存类的几个方法
        //transferTo(File dest) 将上传文件保存到一个目标文件当中
        //getOriginalFilename() 获取上传文件的原始文件名
        //getBytes() 获取文件的字节数组
        //getInputStream() 获取文件的输入流
        //getSize() 获取文件的字节大小
        String originalFilename = image.getOriginalFilename();
        //原始文件名会造成文件名重复，所以需要改名，不能重复，所以使用uuid（通用唯一识别码）
        int index=originalFilename.lastIndexOf(".");
        String houzhui=originalFilename.substring(index);
        String newFilename= UUID.randomUUID().toString() +houzhui;
        log.info("新的文件名：{}", newFilename);
        image.transferTo(new File("D:\\CodeLearning\\Java\\laji\\" + newFilename));
        return Result.success();
    }*/
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public  Result upload(MultipartFile image) throws IOException {
        log.info("接收到的参数：{}",image);
        String upload = aliOSSUtils.upload(image);
        log.info("文件上传完成，Web访问路径：{}",upload);
        return Result.success(upload);
    }
}
