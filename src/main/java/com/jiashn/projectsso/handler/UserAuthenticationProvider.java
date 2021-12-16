package com.jiashn.projectsso.handler;

import com.jiashn.projectsso.user.domain.SelfUser;
import com.jiashn.projectsso.user.domain.SysRole;
import com.jiashn.projectsso.user.service.SysUserService;
import com.jiashn.projectsso.user.service.impl.SelfUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/3 15:29
 **/
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SelfUserDetailsService userDetailsService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginName = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf( authentication.getCredentials());
        SelfUser selfUser = userDetailsService.loadUserByUsername(loginName);
        if (Objects.isNull(selfUser)){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if (!new BCryptPasswordEncoder().matches(password,selfUser.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        if (selfUser.getStatus() == 1){
            throw new LockedException("该账户已禁用");
        }
        // 角色集合
        Set<GrantedAuthority> authorities = new HashSet<>();
        List<SysRole> roles = sysUserService.getRoleByUserId(selfUser.getId());
        for (SysRole role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        selfUser.setAuthorities(authorities);
        return new UsernamePasswordAuthenticationToken(selfUser,password,authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}