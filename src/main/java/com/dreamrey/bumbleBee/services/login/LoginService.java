package com.dreamrey.bumbleBee.services.login;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import com.dreamrey.bumbleBee.dto.LoginDto;
import com.dreamrey.bumbleBee.utility.util.StandardResponse;

public interface LoginService {
    StandardResponse authenticateUser(LoginDto loginDto) throws Exception;
}
