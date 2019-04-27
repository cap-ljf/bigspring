package org.capljf.bigspring.dto;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author jifang.liu created on 2019/4/27 11:52
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
}
