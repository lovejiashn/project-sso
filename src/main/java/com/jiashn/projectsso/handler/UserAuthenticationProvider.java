package com.jiashn.projectsso.handler;

import com.jiashn.projectsso.user.service.impl.SelfUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/3 15:29
 **/
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SelfUserDetailsService userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginName = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf( authentication.getCredentials());
        userDetailsService.loadUserByUsername(loginName)
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}