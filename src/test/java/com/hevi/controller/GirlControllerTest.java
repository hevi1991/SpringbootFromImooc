package com.hevi.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by Hevi on 2017/9/22.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //假如@AutoConfigureMockMvc注解,可以进行模拟请求
public class GirlControllerTest {

    @Autowired
    MockMvc mvc;//模拟客户端请求

    @Test
    public void testController() throws Exception {

        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/girls")).andExpect(MockMvcResultMatchers.status().isOk());
        //所有这些测试类,在使用mvn clean package打包的时候,会进行测试,并且得出测试结果
        //跳过测试mvn clean package -Dmaven.test.skip=true
    }

}