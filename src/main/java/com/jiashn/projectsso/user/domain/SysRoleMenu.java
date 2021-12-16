package com.jiashn.projectsso.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/16 10:42
 **/
@Data
@Accessors(chain = true)
@TableName("sys_role_menu")
public class SysRoleMenu {
    /**
     * 主键Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 角色Id
     */
    private Long roleId;
    /**
     * 权限Id
     */
    private Long menuId;
}