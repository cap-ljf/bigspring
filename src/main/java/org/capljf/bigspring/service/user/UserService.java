package org.capljf.bigspring.service.user;

import org.capljf.bigspring.dto.user.UserDetail;

/**
 * @author jifang.liu created on 2019/5/2 20:31
 */
public interface UserService {

    UserDetail getUserByName(String username);

}
