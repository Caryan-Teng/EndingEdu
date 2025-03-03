package me.caryan.volunteerregistersys.entity.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Caryan
 * @date 2025/3/3 14:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "志愿活动创建日志")
@Builder
public class VolunteerCreateLog {
    @ApiModelProperty(value = "志愿活动创建日志id主键")
    private Long id;
    @NotBlank(message = "志愿活动创建者邮箱不能为空")
    @ApiModelProperty(value = "志愿活动创建者邮箱")
    private String leaderEmail;
    @NotBlank(message = "志愿活动名称不能为空")
    @ApiModelProperty(value = "志愿活动名称")
    private String volunteerName;
}
