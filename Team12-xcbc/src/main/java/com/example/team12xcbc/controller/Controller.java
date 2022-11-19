package com.example.team12xcbc.controller;

import com.example.team12xcbc.Class.s_to_b;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class Controller {
    @Resource
    private s_to_b translate;

    @PostMapping("/translate")
    public void translateService(@RequestParam String num){
    //调用输入函数
        String stringIn = ;
        s_to_b stb = new s_to_b();
        stb.convert(stringIn);

    //调用转换函数

    //调用输出函数

}
