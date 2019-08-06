package com.leyou.item.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author tianwenwen
 * @date 2019/8/6 10:52
 **/
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String test1(@RequestParam("pid")Long pid){
        System.out.println("pid = " + pid);
        return "ss";
    }
    @GetMapping("list")
    public String test3(){
        test2(2L);
        return "sdfsdaf";
    }
    @GetMapping("{pid}")
    public String test2(@PathVariable("pid")Long pid){
        System.out.println("pid = " + pid);
        return null;
    }
}
