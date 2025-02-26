package me.caryan.volunteerregistersys.entity.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Api(tags = "用户签到状态Vo")
/**
 * @author Caryan
 * @date 2025/2/26 09:38
 */
public class UserIsCheckedVo {
    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;
    @ApiModelProperty(value = "志愿活动名称")
    @NotBlank(message = "志愿活动名称不能为空")
    private String volunteerName;
    @ApiModelProperty(value = "是否已签到：-1-未审核/0-否/1-是")
    private Integer isChecked;
}
