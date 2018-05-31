package com.eleven.booklibrary.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* 创建时间：2018年5月31日 上午11:12:53
* 项目名称：BookLibrarySystem
* @author lijinliang
* @version 1.0
* 文件名称：TestRedis.java
* 类说明：
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
public class TestRedis {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test(){
        redisTemplate.opsForValue().set("chen", "陈梓平");
        System.out.println("value："+redisTemplate.opsForValue().get("chen"));
    }
}