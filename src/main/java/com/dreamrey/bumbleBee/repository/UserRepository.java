package com.dreamrey.bumbleBee.repository;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import com.dreamrey.bumbleBee.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByUsername(String userName);
}
