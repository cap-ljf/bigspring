package org.capljf.bigspring.dao;

import org.capljf.bigspring.BigspringApplicationTests;
import org.capljf.bigspring.dto.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author jifang.liu created on 2019/4/28 21:55
 */
public class RedisTemplateTests extends BigspringApplicationTests {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test(){
        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void test1(){
        // 保存对象
        User user = User.of("超人", 20);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = User.of("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getName(), user);

        user = User.of("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getName(), user);

        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().intValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().intValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().intValue());
    }
}
