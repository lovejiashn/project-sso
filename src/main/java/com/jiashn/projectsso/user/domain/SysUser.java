package com.jiashn.projectsso.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

/**
 * @Author: jiangjs
 * @Description: 用户信息表
 * @Date: 2021/12/2 10:21
 **/
@Data
@TableName("sys_user")
public class SysUser {
    /**
     * 主键Id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 登录名
     */
    @NotNull(message = "登录名不能为空")
    private String loginName;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{6,16}$",message = "密码必须包含大小写字母和数字，长度6~16位")
    private String passWord;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 添加者
     */
    private String creator;

    /**
     * 删除
     */
    private Integer deleted;
}