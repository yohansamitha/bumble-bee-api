package com.dreamrey.bumbleBee.utility.util;
/*
 * @author Yohan Samitha
 * @since 4/1/2023
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dreamrey.bumbleBee.dto.PayLoadDTO;
import com.dreamrey.bumbleBee.entity.Users;
import com.dreamrey.bumbleBee.utility.constant.Constant;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

@Component
public class JwtUtil {

    public String getUsernameFromToken(String token) {
        if (token != null) {
            String payLoad = JWT.require(Algorithm.HMAC512(Constant.SECRET.getBytes())).build().verify(token.replace(Constant.TOKEN_PREFIX, "")).getSubject();
            Date expiresAt = JWT.require(Algorithm.HMAC512(Constant.SECRET.getBytes())).build().verify(token.replace(Constant.TOKEN_PREFIX, "")).getExpiresAt();
            if (payLoad != null && !payLoad.isEmpty()) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                PayLoadDTO payLoadDTO = gson.fromJson(payLoad, PayLoadDTO.class);
                payLoadDTO.setExpiresTime(expiresAt);
                return payLoadDTO.getUserName();
            }
        }
        return null;
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        if (token != null) {
            String payLoad = JWT.require(Algorithm.HMAC512(Constant.SECRET.getBytes())).build().verify(token.replace(Constant.TOKEN_PREFIX, "")).getSubject();
            Date expiresAt = JWT.require(Algorithm.HMAC512(Constant.SECRET.getBytes())).build().verify(token.replace(Constant.TOKEN_PREFIX, "")).getExpiresAt();
            if (payLoad != null && !payLoad.isEmpty()) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                PayLoadDTO payLoadDTO = gson.fromJson(payLoad, PayLoadDTO.class);
                payLoadDTO.setExpiresTime(expiresAt);
                return payLoadDTO.getUserName().equals(userDetails.getUsername());
            }
        }
        return false;
    }

    public String generateToken(Users user) {
        String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        PayLoadDTO payLoadBean = new PayLoadDTO(sessionId, user.getUsername());
        // creating the jwt token
        return JWT.create().withSubject(payLoadBean.toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + Constant.EXPIRATION)).sign(Algorithm.HMAC512(Constant.SECRET.getBytes()));
    }
}
