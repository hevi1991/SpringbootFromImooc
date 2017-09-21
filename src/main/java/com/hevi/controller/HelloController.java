package com.hevi.controller;

import com.hevi.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hevi on 2017/9/21.
 */

@RestController
public class HelloController {

    /*
    @Value("${girl.cupSize}")
    private String cupSize;
    @Value("${girl.age}")
    private Integer age;
    @Value("${girl.content}")
    private String content;
    */

    @Autowired
    private GirlProperties girl;

    @RequestMapping(value = {"/hello","/hi"})
    public String say() {
        return girl.getAge()+girl.getCupSize();
    }

    @RequestMapping(value = "/user/{id}")
    public String reflectId(@PathVariable("id") String id){
        return "Your id is "+ id;
    }

    @RequestMapping(value = "/user")
    public String reflectName(@RequestParam(value = "name",required = false,defaultValue = "Peter") String name) {
        return "Your name is "+ name;
    }

    /*
    * 可以使用@GetMapping("route")替代@RequestMapping(value="route",method = RequestMethod.GET)
    * 同理还有@PostMapping, @PutMapping, @DeleteMapping
    * */


}
