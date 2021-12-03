package com.jiashn.projectsso.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jiangjs
 * @date 2021-12-02 6:29
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                //匿名访问url
                .antMatchers().permitAll()
                .anyRequest().authenticated().and()
                //设置自定义登录页
        .formLogin().loginPage("/login.html")
                //自定义的访问路径
                .loginProcessingUrl("/login").permitAll()
                //自定义登录用户名和密码参数，默认：username和password
                .usernameParameter("loginName").passwordParameter("pwd")
                .and()
                //自定义登出页面
                .logout().logoutUrl("loginOut");
        //关闭csrf跨域
        http.csrf().disable();
    }

    /**
     * 用于放行静态资源的访问
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception{
        //设置拦截忽略文件夹,可以对静态资源放行
        web.ignoring().antMatchers("/css/**","/js/**","/login/getCode*","/img/**");
    }
}
