package com.hevi.controller;

import com.hevi.domain.Girl;
import com.hevi.domain.Result;
import com.hevi.enums.ResultEnum;
import com.hevi.exception.GirlException;
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
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) throws Exception{

        if (girl.getAge() < 18) {
            throw new GirlException(ResultEnum.NOT_ENOUGH_AGE.getCode(),ResultEnum.NOT_ENOUGH_AGE.getMsg());
        }

        Girl save = girlRepository.save(girl);
        return new Result<Girl>(0,"成功",save);
    }

    @GetMapping(value="/girls/{id}")
    public Girl findGirlById(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value="/girls/{id}")
    public Result updateGirl(@PathVariable("id")Integer id,
                           @RequestParam("age")Integer age,
                           @RequestParam("cupSize")String cupSize) throws GirlException{


        if (age < 18) {
            throw new GirlException(ResultEnum.NOT_ENOUGH_AGE.getCode(),ResultEnum.NOT_ENOUGH_AGE.getMsg());
        }

        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        Girl save = girlRepository.save(girl);
        if (save != null){
            return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg());
        }

        throw new GirlException(ResultEnum.ACTION_FAILD.getCode(),ResultEnum.ACTION_FAILD.getMsg());
    }

    @DeleteMapping("/girls/{id}")
    public Result removeGirlById(@PathVariable("id")Integer id){

        girlRepository.delete(id);
        return new Result(0,"删除成功");
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
