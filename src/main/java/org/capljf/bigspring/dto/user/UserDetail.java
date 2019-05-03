package org.capljf.bigspring.dto.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author jifang.liu created on 2019/5/2 20:45
 */
@Entity
@Data
public class UserDetail {
    @Id
    @GeneratedValue()
    private Integer id;
    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 20)
    private String password;
}
