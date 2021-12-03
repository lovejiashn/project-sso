package com.jiashn.projectsso.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/3 14:41
 **/
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    public static String secret;
    public static String tokenHeader;
    public static String tokenPrefix;
    public static Integer expiration;
    public static String antMatchers;
}