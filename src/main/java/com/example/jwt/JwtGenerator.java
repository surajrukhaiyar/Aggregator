package com.example.jwt;


import org.springframework.stereotype.Component;

import com.example.constant.SecurityConstants;
import com.example.entity.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {


    public String generate(Users jwtUser) {

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
//        claims.put("role", jwtUser.getRole());
        claims.put("password", jwtUser.getPassword());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
                .compact();
    }
}
