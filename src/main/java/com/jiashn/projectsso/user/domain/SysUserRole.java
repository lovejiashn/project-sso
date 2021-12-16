package com.jiashn.projectsso.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/6 10:37
 **/
@Data
@Accessors(chain = true)
@TableName("sys_user_role")
public class SysUserRole {

    /**
     * 主键Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 角色Id
     */
    private Long roleId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}