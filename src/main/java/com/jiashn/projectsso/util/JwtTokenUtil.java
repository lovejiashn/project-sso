package com.jiashn.projectsso.util;

import com.jiashn.projectsso.config.JwtConfig;
import com.jiashn.projectsso.user.domain.SelfUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Author: jiangjs
 * @Description: jwt生成token
 * @Date: 2021/12/3 14:24
 **/
public class JwtTokenUtil {

    /**
     * 生成Token
     * @param selfUser 用户安全实体
     * @return 返回生成的token
     */
    public static String createAccessToken(SelfUser selfUser){

        String token = Jwts.builder()
                //放入用户Id
                .setId(String.valueOf(selfUser.getId()))
                //主题
                .setSubject(selfUser.getLoginName())
                //签发时间
                .setIssuedAt(new Date())
                //签发人
                .setIssuer("jiashn")
                //自定义属性，放入用户拥有的权限
                .claim("authorities",selfUser.getAuthorities())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + JwtConfig.expiration))
                //签名算法和密钥
                .signWith(SignatureAlgorithm.HS512,JwtConfig.secret)
                .compact();
        return token;
    }
}