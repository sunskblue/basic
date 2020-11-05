package com.sunskblue.basicclient.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ApiModel("用户视图模型")
public class TUser {

    @ApiModelProperty("用户 ID")
    private Integer userId;

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是6-11个字符")
    private String username;

    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 11, message = "密码长度必须是6-16个字符")
    private String password;

    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空")
    @Size(min = 11, max = 11, message = "手机号必须为 11 位")
    private String phone;
}
