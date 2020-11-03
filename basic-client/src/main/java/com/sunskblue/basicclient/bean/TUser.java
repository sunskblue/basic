package com.sunskblue.basicclient.bean;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class TUser {
    private Integer userId;

    private String userName;

    private String password;

    private String phone;
}
