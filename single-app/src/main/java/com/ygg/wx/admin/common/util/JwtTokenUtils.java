package com.ygg.wx.admin.common.util;

import com.ygg.debt.common.constants.CommonConstant;
import com.ygg.wx.admin.model.dto.AuthUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author akhan
 * @description
 * @date 17:01 2018-11-22
 */
@Component
public class JwtTokenUtils implements Serializable {

    private String secret = null;

    @PostConstruct
    void init() {
        secret = CommonConstant.SIGN_KEY;
    }

    /**
     * 生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + CommonConstant.TOKEN_EXPIRE_TIME);

        System.out.println(Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     *
     * @param login 登陆用户
     * @return 令牌
     */
    public String generateToken(AuthUser login) {
        Map<String, Object> claims = new HashMap<>(3);
        claims.put("sub", login.getUsername());
        claims.put("ver", login.getJwtVersion());
        claims.put("jti", UUID.randomUUID());
        claims.put("created", new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getPhoneFromToken(String token) {
        String phone;
        try {
            Claims claims = getClaimsFromToken(token);
            phone = claims.getSubject();
        } catch (Exception e) {
            phone = null;
        }
        return phone;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        AuthUser user = (AuthUser) userDetails;
        Claims claims = getClaimsFromToken(token);
        String username = claims.getSubject();
        Date version = claims.get("ver", Date.class);
        return (username.equals(user.getUsername()) && !isTokenExpired(token) && user.getJwtVersion().equals(version));
    }

}
