package org.capljf.bigspring.jpa;

import org.capljf.bigspring.BigspringApplication;
import org.capljf.bigspring.dao.CustomerRepository;
import org.capljf.bigspring.dto.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author jifang.liu created on 2019/4/16 10:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BigspringApplication.class)
public class SpringDataJpaTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test(){
        customerRepository.save(new Customer("jifang", "liu"));
        customerRepository.save(new Customer("haiyan", "ye"));
        customerRepository.save(new Customer("guess", "hi"));

        Assert.assertEquals(3, customerRepository.findAll().size());

        Assert.assertEquals("liu", customerRepository.findByFirstName("jifang").getLastName());

        Assert.assertEquals(new Customer("jifang", "liu"), customerRepository.findUser("jifang", "liu"));
    }
}
