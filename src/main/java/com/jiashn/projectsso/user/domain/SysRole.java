package com.jiashn.projectsso.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/6 14:30
 **/
@Data
@Accessors(chain = true)
@TableName("sys_role")
public class SysRole {
    /**
     * 主键Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 角色名称
     */
    private String roleName;
}