package org.capljf.bigspring.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.capljf.bigspring.dto.Customer;
import org.capljf.bigspring.pojo.json.JsonObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jifang.liu created on 2019/4/16 16:34
 */
@Slf4j
public class JacksonUtilTest {

    @Test
    public void writeToStringTest(){
        Customer customer = new Customer("jfiang", "liu");
        log.info(JacksonUtil.toJson(customer));
    }

    @Test
    public void jsonToObjectTest(){
        String json = "{\"id\":null,\"firstName\":\"jfiang\",\"lastName\":\"liu\",\"test\":\"1\"}";
        Customer customer = JacksonUtil.readValue(json, Customer.class);
        log.info(customer.toString());
        Assert.assertEquals(customer.getClass(), Customer.class);
    }

    @Test
    public void anotationTest(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.setUserName("jfiang");
        jsonObject.setCreateTime(new Date());
        log.info(JacksonUtil.toJson(jsonObject));
    }

    @Test
    public void collectionParseTest(){
        List<JsonObject> jsonObjectList = Lists.newArrayList();
        String jsonString = JacksonUtil.toJson(jsonObjectList);
//        Object value = JacksonUtil.readValue(jsonString, new TypeReference<List<JsonObject>>() {
//        });
        List<JsonObject> value = JacksonUtil.readListValue(jsonString, JsonObject.class);
        Assert.assertEquals(value.getClass(), ArrayList.class);
    }

    @Test
    public void mapParseTest(){
        Map<String, Customer> map = Maps.newHashMap();
        String jsonString = JacksonUtil.toJson(map);
//        Map<String, Customer> customerMap = JacksonUtil.readMapValue(jsonString, Customer.class);
        Object customerMap = JacksonUtil.readValue(jsonString, new TypeReference<HashMap<String, Customer>>() {
        });
        Assert.assertEquals(HashMap.class, customerMap.getClass());
    }
}
