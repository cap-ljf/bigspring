package org.capljf.bigspring.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author jifang.liu created on 2019/4/27 11:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcTemplateTests {

    @Resource
    private UserDao userDao;

    @Before
    public void setUp(){
        userDao.deleteAllUsers();
    }

    @Test
    public void test(){
        // 插入5个用户
        userDao.create("a", 1);
        userDao.create("b", 2);
        userDao.create("c", 3);
        userDao.create("d", 4);
        userDao.create("e", 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userDao.getAllUsers().intValue());

        // 删除两个用户
        userDao.deleteByName("a");
        userDao.deleteByName("e");

        // 查数据库，应该有3个用户
        Assert.assertEquals(3, userDao.getAllUsers().intValue());
    }
}
