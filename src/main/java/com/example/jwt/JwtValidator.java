package com.example.jwt;

import org.springframework.stereotype.Component;

import com.example.constant.SecurityConstants;
import com.example.entity.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {


    private String secret = SecurityConstants.SECRET;

    public Users validate(String token) {

    	Users jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new Users();
            jwtUser.setName(body.getSubject());
            jwtUser.setPassword(body.get("password", String.class));
            
//            Role role = new Role();
//            role.setRole((String)body.get("role", LinkedHashMap.class).get("role"));
//            role.setRoleId((Integer)body.get("role", LinkedHashMap.class).get("roleId"));
//            jwtUser.setRole(role);
            
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}