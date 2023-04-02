package com.dreamrey.bumbleBee.controller;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import com.dreamrey.bumbleBee.dto.LoginDto;
import com.dreamrey.bumbleBee.services.login.LoginService;
import com.dreamrey.bumbleBee.utility.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/bb")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/login")
    public StandardResponse login(@Valid @RequestBody LoginDto loginDto) throws Exception {
        System.out.println("Username : " + loginDto.getUsername());
        System.out.println("Password : " + loginDto.getPassword());
        return loginService.authenticateUser(loginDto);
    }
}
