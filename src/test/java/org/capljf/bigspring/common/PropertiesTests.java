package org.capljf.bigspring.common;

import org.capljf.bigspring.BigspringApplicationTests;
import org.capljf.bigspring.common.properties.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jifang.liu created on 2019/5/2 16:03
 */
public class PropertiesTests extends BigspringApplicationTests {

    @Autowired
    private BlogProperties blogProperties;


    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(blogProperties.getName(), "cap-ljf");
        Assert.assertEquals(blogProperties.getTitle(), "Learn Spring Boot");
    }


}
