package com.hevi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * Created by Hevi on 2017/9/21.
 */

//JPA注解,@Entity意味这个是数据库的一张表,
@Entity
public class Girl {
    //@Id id字段,自增
    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }

    private Integer age;

    //一定要有空白的构造器
    public Girl() {
    }

    //需要getter和setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
