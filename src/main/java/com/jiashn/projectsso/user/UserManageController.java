package com.jiashn.projectsso.user;

import com.jiashn.projectsso.user.domain.SysUser;
import com.jiashn.projectsso.util.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/2 10:07
 **/
@RestController
@RequestMapping("/user")
public class UserManageController {

    @PostMapping("/login.do")
    public ResultVO<?> userLogin(@RequestBody @Validated SysUser sysUser){
        return null;
    }
}