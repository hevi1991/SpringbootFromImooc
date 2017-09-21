package com.hevi.repository;

import com.hevi.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Hevi on 2017/9/21.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {//继承jpaRepository ,前一个泛型,写处理的实体,第二个写id类型
    //扩展设置特殊查找,JPA 方法名是有讲究的
    public List<Girl> findByAge(Integer age);
}
