package me.caryan.volunteerregistersys.entity.Request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
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
     * 登录电话
     */
    @NotBlank(message = "登录电话不能为空")
    @ApiModelProperty(value = "登录电话")
    private String tel;
    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空")
    @ApiModelProperty(value = "登录电话")
    private String password;
}
