package com.example.team12xcbc.controller;

import com.example.team12xcbc.Class.Judge;
import com.example.team12xcbc.Class.s_to_b;
import com.example.team12xcbc.Class.b_to_s;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class Controller {
    @PostMapping("/translate")
    public String translateService(@RequestParam String num){
        String stringIn = num;
        Judge judge = new Judge();
        int flag = Judge.judge(num);
        if(flag==1){
            //小写转大写
            s_to_b stb = new s_to_b();
            return stb.convert(stringIn);
        }
        esle if(flag==2){
            //大写转小写
            b_to_s bts = new b_to_s();
            return bts.c2u(stringIn);
        }
        else if(flag==0) {
            return "error";
        }
}
