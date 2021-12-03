package com.jiashn.projectsso.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jiashn.projectsso.user.domain.SysUser;
import com.jiashn.projectsso.user.mapper.SysUserMapper;
import com.jiashn.projectsso.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/3 15:37
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getSysUserByLoginName(String loginName) {
        Wrapper<SysUser> userWrapper = Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getLoginName,loginName);
        SysUser sysUser = sysUserMapper.selectOne(userWrapper);
        return sysUser;
    }
}