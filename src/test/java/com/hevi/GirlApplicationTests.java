package com.hevi;

import com.hevi.domain.Girl;
import com.hevi.service.GirlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//单元测试,必须引入以下两个注解
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	GirlService girlService;

	//测试方法
	@Test
	public void contextLoads() {

		List<Girl> girls = girlService.girlLists();
		logger.info(girls.toString());

	}

}
