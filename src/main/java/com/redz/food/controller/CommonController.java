package com.redz.food.controller;

import com.redz.food.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    //文件上传
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        if (file.isEmpty()){
            return R.error("文件为空");
        }
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\file\\" + file.getOriginalFilename();
        File file1 = new File(path);
        if(file1.exists()){
            return R.error("文件名重复或者文件已存在");
        }
        try{
            file.transferTo(file1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return R.success("上传成功");
    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            //输入流，通过输入流读取文件内容
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("file\\" + name);
            //输出流，通过输出流将文件写回浏览器，在浏览器中展示图片
            ServletOutputStream outputStream = response.getOutputStream();

            int len=0;
            byte[] bytes = new byte[1024];
            while ((len=resourceAsStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            resourceAsStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
