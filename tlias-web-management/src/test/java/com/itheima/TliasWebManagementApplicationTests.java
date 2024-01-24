package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }
    /*测试生成jwt令牌*/
    @Test
    public void testGwnJwt(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")//签名算法
                .setClaims(claims)//自定义内容，载荷
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//定义有效时间
                .compact();//生成jwt字符串
        System.out.println(jwt);
    }
    /*jwt令牌解码测试*/
    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定签名密钥 必须配套
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjE" +
                        "sImV4cCI6MTcwNjA5MzU2Mn0.LmREuDwkH8RxOj_93i4eL8WhRAcVnJDWyj-SYYVr5co")//解析令牌
                .getBody();
        System.out.println(claims);
    }

}
