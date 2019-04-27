package org.capljf.bigspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author jifang.liu created on 2019/4/27 11:52
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    @NonNull
    private String name;
    @Column(nullable = false)
    @NonNull
    private Integer age;
}
