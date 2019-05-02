package org.capljf.bigspring.jpa;

import org.capljf.bigspring.BigspringApplication;
import org.capljf.bigspring.BigspringApplicationTests;
import org.capljf.bigspring.dao.CustomerRepository;
import org.capljf.bigspring.dao.repo.UserRepository;
import org.capljf.bigspring.dto.Customer;
import org.capljf.bigspring.dto.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author jifang.liu created on 2019/4/16 10:18
 */
public class SpringDataJpaTests extends BigspringApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;
    @Resource
    private UserRepository userRepository;

    @Test
    public void test(){
        customerRepository.save(new Customer("jifang", "liu"));
        customerRepository.save(new Customer("haiyan", "ye"));
        customerRepository.save(new Customer("guess", "hi"));

        Assert.assertEquals(3, customerRepository.findAll().size());

        Assert.assertEquals("liu", customerRepository.findByFirstName("jifang").getLastName());

        Assert.assertEquals(new Customer("jifang", "liu"), customerRepository.findUser("jifang", "liu"));
    }

    @Test
    public void userTest(){
        // 创建10条记录
        userRepository.save(User.of("AAA", 10));
        userRepository.save(User.of("BBB", 20));
        userRepository.save(User.of("CCC", 30));
        userRepository.save(User.of("DDD", 40));
        userRepository.save(User.of("EEE", 50));
        userRepository.save(User.of("FFF", 60));
        userRepository.save(User.of("GGG", 70));
        userRepository.save(User.of("HHHHHHHHH", 80));
        userRepository.save(User.of("III", 90));
        userRepository.save(User.of("JJJ", 100));

        // 测试findAll, 查询所有记录
        Assert.assertEquals(10, userRepository.findAll().size());

        // 测试findByName, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findByName("FFF").getAge().longValue());

        // 测试findUser, 查询姓名为FFF的User
        Assert.assertEquals(60, userRepository.findUser("FFF").getAge().longValue());

        // 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
        Assert.assertEquals("FFF", userRepository.findByNameAndAge("FFF", 60).getName());

        // 测试删除姓名为AAA的User
        userRepository.delete(userRepository.findByName("AAA"));

        // 测试findAll, 查询所有记录, 验证上面的删除是否成功
        Assert.assertEquals(9, userRepository.findAll().size());
    }
}
