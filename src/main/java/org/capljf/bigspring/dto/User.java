package org.capljf.bigspring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author jifang.liu created on 2019/4/27 11:52
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 10)
    @NonNull
    private String name;
    @Column(nullable = false)
    @NonNull
    private Integer age;
}
