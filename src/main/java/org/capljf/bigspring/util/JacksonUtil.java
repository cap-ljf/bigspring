package org.capljf.bigspring.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Jackson工具 参考文档 https://www.ibm.com/developerworks/cn/java/jackson-advanced-application/index.html
 * @author jifang.liu created on 2019/4/16 16:24
 */
@Slf4j
public class JacksonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * java object to json
     * @param o
     * @return
     */
    public static String toJson(Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("object write to jsonString failed.", e);
        }
        return null;
    }

    public static <T> T readValue(String jsonString, Class<T> tClass){
        try {
            return objectMapper.readValue(jsonString, tClass);
        } catch (IOException e) {
            log.error("json to java object failed. jsonString:{}, classType:{}", jsonString, tClass.getName(), e);
        }
        return null;
    }

    public static <T> List<T> readListValue(String jsonString, Class<T> tClass){
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, tClass);
        try {
            return objectMapper.readValue(jsonString, collectionType);
        } catch (IOException e) {
            log.error("parse json list value failed. jsonString:{}, classType:{}", jsonString, tClass);
        }
        return null;
    }

    public static <T> Map<String, T> readMapValue(String jsonString, Class<T> tClass){
        MapType mapType = objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, tClass);
        try {
            return objectMapper.readValue(jsonString, mapType);
        } catch (IOException e) {
            log.error("parse json Map value failed. jsonString:{}, classType:{}", jsonString, tClass);
        }
        return null;
    }

    public static Object readValue(String jsonString, TypeReference typeReference){
        try {
            return objectMapper.readValue(jsonString, typeReference);
        } catch (IOException e) {
            log.error("read json value failed. jsonString:{}, typeReference:{}", jsonString, typeReference.getType(), e);
        }
        return null;
    }

}
