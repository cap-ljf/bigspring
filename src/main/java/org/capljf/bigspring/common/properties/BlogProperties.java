package org.capljf.bigspring.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jifang.liu created on 2019/5/2 16:02
 */
@Component
@Data
public class BlogProperties {

    @Value("${com.jifang.blog.name}")
    private String name;
    @Value("${com.jifang.blog.title}")
    private String title;

}
