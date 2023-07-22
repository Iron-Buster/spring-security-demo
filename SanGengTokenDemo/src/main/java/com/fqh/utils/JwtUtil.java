package com.fqh.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    /**
     * jwt有效期 1小时
     */
    public static final Long JWT_TTL = 60 * 60 * 1000L;
    /**
     * 设置密钥明文
     */
    public static final String JWT_KEY = "sangeng";

    public static String getUUID() {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        return token;
    }

    public static String createJWT(String subject) {
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID()); // 设置过期时间
        return builder.compact();
    }

    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }


    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                .setId(uuid)                                // 唯一id
                .setSubject(subject)                        // 主题 可以是json数据
                .setIssuer("sg")                            // 签发者
                .setIssuedAt(now)                           // 签发时间
                .signWith(signatureAlgorithm, secretKey)    // 使用HS256对称加密算法签名 第二个参数为秘钥
                .setExpiration(expDate);
    }

    public static SecretKey generalKey() {
        byte[] encodeKey = Base64.getDecoder().decode(JWT_KEY);
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }

    /**
     * 解析
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }


    public static void main(String[] args) throws Exception {
//        String jwt = createJWT("11");
//        System.out.println(jwt);
        Claims claims = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiNzViYWY4Y2VlYmQ0MWY4YjZkZjY1Mjc1M2ZhZjQ3OCIsInN1YiI6IjExIiwiaXNzIjoic2ciLCJpYXQiOjE2OTAwMDQ3OTYsImV4cCI6MTY5MDAwODM5Nn0.UOvBRdQRbpPYYNGKfEYH356kMOQOonr0Zr3NfaXgHFI");
        claims = parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI0YWI0NDNhOWE4MzM0ZDRlODY3OTY5YThmYWY2NzdiNCIsInN1YiI6IjIiLCJpc3MiOiJzZyIsImlhdCI6MTY5MDAwNjM1MCwiZXhwIjoxNjkwMDA5OTUwfQ.rK8byYsR4tO4f7skKBobOihXQXAouJZLU8Txo6s_B2g");
        System.out.println(claims.getSubject());
    }


}
