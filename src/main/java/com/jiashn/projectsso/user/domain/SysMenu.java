package com.jiashn.projectsso.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/16 10:40
 **/
@Data
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenu {
    /**
     * 权限Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long menuId;
    /**
     * 权限名称
     */
    private String menuName;
    /**
     * 权限标识
     */
    private String permission;
}