package com.dreamrey.bumbleBee.services.login.impl;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import com.dreamrey.bumbleBee.dto.LoginDto;
import com.dreamrey.bumbleBee.entity.Users;
import com.dreamrey.bumbleBee.repository.UserRepository;
import com.dreamrey.bumbleBee.services.login.LoginService;
import com.dreamrey.bumbleBee.utility.util.JwtUtil;
import com.dreamrey.bumbleBee.utility.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public StandardResponse authenticateUser(LoginDto loginDto) throws Exception {
        StandardResponse responseBean = new StandardResponse();
        HashMap<String, Object> responseData = new HashMap<>();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );

        Optional<Users> byUsername = userRepository.findByUsername(loginDto.getUsername());
        Users user;
        String token;
        if (byUsername.isPresent()) {
            user = byUsername.get();
            token = jwtUtil.generateToken(user);
            responseData.put("userData", user);
            responseData.put("token", token);
        }
        responseBean.setMessage("User Successfully login");
        responseBean.setCode(HttpStatus.OK.toString());
        responseBean.setData(responseData);
        return responseBean;
    }
}
