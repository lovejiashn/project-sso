package com.jiashn.projectsso.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jiashn.projectsso.user.domain.*;
import com.jiashn.projectsso.user.mapper.*;
import com.jiashn.projectsso.user.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/3 15:37
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public SysUser getSysUserByLoginName(String loginName) {
        Wrapper<SysUser> userWrapper = Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getLoginName,loginName);
        return sysUserMapper.selectOne(userWrapper);
    }

    @Override
    public List<SysRole> getRoleByUserId(Long userId) {
        Wrapper<SysUserRole> userRoleWrapper = Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId,userId);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(userRoleWrapper);
        if (!CollectionUtils.isEmpty(sysUserRoles)){
            List<Long> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
            Wrapper<SysRole> roleWrapper = Wrappers.<SysRole>lambdaQuery()
                    .in(SysRole::getId,roleIds);
            return sysRoleMapper.selectList(roleWrapper);
        }
        return null;
    }

    @Override
    public List<SysMenu> getSysMenuByUserId(Long userId) {
        List<SysMenu> menus = new ArrayList<>();
        //通过用户Id获取角色信息
        Wrapper<SysUserRole> userRoleWrapper = Wrappers.<SysUserRole>lambdaQuery()
                .eq(SysUserRole::getUserId,userId);
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(userRoleWrapper);
        if (!CollectionUtils.isEmpty(sysUserRoles)){
            List<Long> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
            //通过角色获取权限信息
            Wrapper<SysRoleMenu> roleMenuWrapper = Wrappers.<SysRoleMenu>lambdaQuery()
                    .in(SysRoleMenu::getRoleId,roleIds);
            List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectList(roleMenuWrapper);
            if (!CollectionUtils.isEmpty(sysRoleMenus)){
                List<Long> menuIds = sysRoleMenus.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
                Wrapper<SysMenu> menuWrapper = Wrappers.<SysMenu>lambdaQuery()
                        .in(SysMenu::getMenuId,menuIds);
                menus = sysMenuMapper.selectList(menuWrapper);
            }
        }
        return menus;
    }
}