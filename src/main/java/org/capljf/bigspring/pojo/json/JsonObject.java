package org.capljf.bigspring.pojo.json;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author jifang.liu created on 2019/4/16 16:52
 */
@Data
@JsonPropertyOrder({"createTime","userName"})
public class JsonObject {

    @JsonProperty(value = "user_name")
    private String userName;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

//    private Map<String, Object> map = Maps.newHashMap();

//    @JsonAnySetter
//    public void set(String key, Object value){
//        map.put(key, value);
//    }

}
