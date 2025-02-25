package me.caryan.volunteerregistersys.entity.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Api(tags = "用户验证码")
public class UserPass {
    @ApiModelProperty(value = "用户验证码id主键")
    private Integer id;
    @NotBlank(message = "邮箱地址不能为空")
    @ApiModelProperty(value = "邮箱地址")
    private String email;
    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码")
    private String pass;
}
