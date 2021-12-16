package com.jiashn.projectsso.user.service;

import com.jiashn.projectsso.user.domain.SysMenu;
import com.jiashn.projectsso.user.domain.SysRole;
import com.jiashn.projectsso.user.domain.SysUser;

import java.util.List;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/3 15:36
 **/
public interface SysUserService {

    /**
     * 根据登录用户名获取用户信息
     * @param loginName 登录用户名
     * @return 返回用户信息
     */
    SysUser getSysUserByLoginName(String loginName);

    /**
     * 根据用户Id获取角色信息
     * @param userId 用户Id
     * @return 返回角色
     */
    List<SysRole> getRoleByUserId(Long userId);

    /**
     * 通过用户Id获取权限信息
     * @param userId 用户Id
     * @return 权限信息
     */
    List<SysMenu> getSysMenuByUserId(Long userId);
}
