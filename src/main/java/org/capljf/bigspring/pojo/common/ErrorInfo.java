package org.capljf.bigspring.pojo.common;

import lombok.Data;

/**
 * @author jifang.liu created on 2019/5/2 15:47
 */
@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;

}
