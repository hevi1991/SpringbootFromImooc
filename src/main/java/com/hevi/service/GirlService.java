package com.hevi.service;

import com.hevi.domain.Girl;
import com.hevi.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hevi on 2017/9/21.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> girlLists(){
        return girlRepository.findAll();
    }

    @Transactional//加注解@Transactional来达到事务控制
    public void insertTwo(){

        Girl girlA = new Girl();
        girlA.setCupSize("C");
        girlA.setAge(28);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("E");//故意超出字符
        girlB.setAge(26);
        girlRepository.save(girlB);

    }


}
