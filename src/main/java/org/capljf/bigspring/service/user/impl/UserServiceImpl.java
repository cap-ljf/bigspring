package org.capljf.bigspring.service.user.impl;

import org.capljf.bigspring.dao.repo.UserDetailRepository;
import org.capljf.bigspring.dto.user.UserDetail;
import org.capljf.bigspring.service.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jifang.liu created on 2019/5/2 20:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetail getUserByName(String username) {
        return userDetailRepository.findUserDetailByUsername(username);
    }
}
