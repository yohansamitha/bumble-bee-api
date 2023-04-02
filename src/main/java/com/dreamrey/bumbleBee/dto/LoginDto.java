package com.dreamrey.bumbleBee.dto;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
}
