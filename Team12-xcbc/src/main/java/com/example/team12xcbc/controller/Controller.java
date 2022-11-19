package com.Team12.YQdemo.controller控制层包;

import com.example.team12xcbc.service.Translate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class Controller {
    @Resource
    private Translate translate;

    /*
    @PostMapping("/translate")
    public  (@RequestParam String num){
    //调用输入函数
    //调用转换函数
    //调用输出函数
   */
}
