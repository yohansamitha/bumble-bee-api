package com.dreamrey.bumbleBee.repository;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import com.dreamrey.bumbleBee.entity.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Userrole, String> {
}
