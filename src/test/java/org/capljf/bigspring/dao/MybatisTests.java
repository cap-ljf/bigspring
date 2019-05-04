package org.capljf.bigspring.dao;

import org.capljf.bigspring.BigspringApplicationTests;
import org.capljf.bigspring.dao.mapper.UserMapper;
import org.capljf.bigspring.dto.User;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jifang.liu created on 2019/5/3 15:15
 */
public class MybatisTests extends BigspringApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void findByName(){
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
    }

    @Test
    public void testUserMapper() throws Exception {
        // insert一条数据，并select出来验证
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        u = userMapper.findByName("AAA");
        Assert.assertEquals(30, u.getAge().intValue());
        // 删除这条数据，并select验证
        userMapper.delete(u.getId());
        u = userMapper.findByName("AAA");
        Assert.assertEquals(null, u);
    }

    @Test
    public void testResults() {
        List<User> userList = userMapper.findAll();
        for(User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getName());
        }
    }
}
