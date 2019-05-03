package org.capljf.bigspring.service.user;

import org.capljf.bigspring.dto.user.UserDetail;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jifang.liu created on 2019/5/2 20:29
 */
//@Service
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetail userDetail = userService.getUserByName(username);
        if (null == userDetail){
            throw new UsernameNotFoundException(username);
        }
//        return new User(userDetail.getUsername(), userDetail.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return new User(username, "123",  AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
