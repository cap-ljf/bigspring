package org.capljf.bigspring.dao.repo;

import org.capljf.bigspring.dto.user.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jifang.liu created on 2019/5/2 20:49
 */
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    UserDetail findUserDetailByUsername(String username);

    UserDetail findUserDetailByUsernameAndPassword(String username, String password);

}
