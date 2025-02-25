package me.caryan.volunteerregistersys.entity.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Api(tags = "志愿报名Vo")
public class RegisterVolunteerVo {
    @ApiModelProperty(value = "志愿活动名称")
    @NotNull(message = "志愿活动名称不能为空")
    private String volunteerName;
    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;
}
