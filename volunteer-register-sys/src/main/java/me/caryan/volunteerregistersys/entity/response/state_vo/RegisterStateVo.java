package me.caryan.volunteerregistersys.entity.response.state_vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "注册状态Vo")
public class RegisterStateVo extends StateVo{
    @ApiModelProperty(value = "注册电话：失败为null")
    private String tel;
}
