package com.dreamrey.bumbleBee.utility.util;
/*
 * @author Yohan Samitha
 * @since 4/2/2023
 */

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class StandardResponse {
    private String code;
    private String message;
    private HashMap<String, Object> data;
}
