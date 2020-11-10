package com.sunskblue.basicserver.dto;

import lombok.Getter;
import lombok.Setter;



/**
 * @author sunshaokang
 * @date Created in 2020/11/6 12:41 下午
 * Description：
 */
@Getter
@Setter
public class UserSearchParam extends PageDTO {
    private Integer userId;
    private String username;
    private String password;
    private String phone;
}
