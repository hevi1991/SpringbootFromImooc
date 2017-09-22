package com.hevi.controller;

import com.hevi.domain.Girl;
import com.hevi.repository.GirlRepository;
import com.hevi.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Hevi on 2017/9/21.
 */

@RestController
public class GirlController {

    @Autowired
    GirlRepository girlRepository;

    @Autowired
    GirlService girlService;

    @GetMapping("/girls")
    public List<Girl> girlLists(){
        return girlRepository.findAll();
    }

    @PostMapping("/girls")
    public String addGirl(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldError().getDefaultMessage();
        }

        Girl save = girlRepository.save(girl);
        return "Save Successed";
    }

    @GetMapping(value="/girls/{id}")
    public Girl findGirlById(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value="/girls/{id}")
    public String updateGirl(@PathVariable("id")Integer id,
                           @RequestParam("age")Integer age,
                           @RequestParam("cupSize")String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        Girl save = girlRepository.save(girl);
        if (save != null){
            return "Update Successed";
        }
        return "Update Failed";
    }

    @DeleteMapping("/girls/{id}")
    public String removeGirlById(@PathVariable("id")Integer id){
        try {
            girlRepository.delete(id);
        } catch (Exception err){
            System.out.println("err:"+err.getMessage());
            return "Delete Failed";
        }
        return "Delete Successed";
    }

    //特殊查找
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age")Integer age){
        return girlRepository.findByAge(age);
    }

    //演示事务
    @PostMapping("/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}
