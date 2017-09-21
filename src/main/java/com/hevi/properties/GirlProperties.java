package com.hevi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Hevi on 2017/9/21.
 */

@Component
@ConfigurationProperties(prefix = "girl")//将配置文件girl前缀的配置写入此类中
public class GirlProperties {

    private String cupSize;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
