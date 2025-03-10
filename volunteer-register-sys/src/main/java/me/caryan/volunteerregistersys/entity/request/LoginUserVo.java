package me.caryan.volunteerregistersys.entity.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "登录用户Vo")
public class LoginUserVo {
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱地址")
    @NotBlank(message = "登录邮箱不能为空")
    private String email;
    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空")
    @ApiModelProperty(value = "登录电话")
    private String password;
}
