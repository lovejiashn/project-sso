package com.jiashn.projectsso.handler;

import com.jiashn.projectsso.user.domain.SelfUser;
import com.jiashn.projectsso.user.domain.SysMenu;
import com.jiashn.projectsso.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: jiangjs
 * @Description: 自定义用户权限注解验证
 * @Date: 2021/12/6 14:57
 **/
public class UserPermissionEvaluator implements PermissionEvaluator{
    @Autowired
    private SysUserService sysUserService;
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        SelfUser selfUser = (SelfUser)authentication.getPrincipal();
        Set<String> permissions = new HashSet<>();
        List<SysMenu> sysMenus = sysUserService.getSysMenuByUserId(selfUser.getId());
        for (SysMenu sysMenu : sysMenus) {
            permissions.add(sysMenu.getPermission());
        }
        //权限对比
        if (permissions.contains(permission)){
            return Boolean.TRUE;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}