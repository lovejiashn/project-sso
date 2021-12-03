package com.jiashn.projectsso.user.service.impl;

import com.jiashn.projectsso.user.domain.SelfUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/3 15:32
 **/
@Component
public class SelfUserDetailsService implements UserDetailsService {
    @Override
    public SelfUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}