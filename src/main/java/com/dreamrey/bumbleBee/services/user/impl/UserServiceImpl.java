package com.dreamrey.bumbleBee.services.user.impl;
/*
 * @author Yohan Samitha
 * @since 4/1/2023
 */

import com.dreamrey.bumbleBee.repository.UserRepository;
import com.dreamrey.bumbleBee.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
