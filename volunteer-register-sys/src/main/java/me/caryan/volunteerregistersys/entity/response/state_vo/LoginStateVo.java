package me.caryan.volunteerregistersys.entity.response.state_vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "登录状态Vo")
public class LoginStateVo extends StateVo{
    @ApiModelProperty(value = "是否为志愿负责人：0-否/1-是")
    private Integer isLeader;
}
