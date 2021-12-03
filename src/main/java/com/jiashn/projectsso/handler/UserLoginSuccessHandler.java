package com.jiashn.projectsso.handler;

import com.jiashn.projectsso.user.domain.SelfUser;
import com.jiashn.projectsso.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: jiangjs
 * @Description: 登录成功处理类
 * @Date: 2021/12/3 15:20
 **/
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SelfUser selfUser = (SelfUser)authentication.getPrincipal();
        String token = JwtTokenUtil.createAccessToken(selfUser);
        log.info("获取到的token:"+token);
        response.sendRedirect("/index.html");
    }
}