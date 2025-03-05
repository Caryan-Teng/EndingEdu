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
 * @date 2025/3/5 15:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Api(tags = "活动签到码绑定实体类")
public class VolunteerCheckCode {
    @ApiModelProperty(value = "活动签到码绑定id主键")
    private Long id;
    @ApiModelProperty(value = "用户邮箱")
    @NotBlank(message = "用户邮箱不能为空")
    private String userEmail;
    @ApiModelProperty(value = "志愿活动名称")
    @NotBlank(message = "志愿活动名称不能为空")
    private String volunteerName;
    @ApiModelProperty(value = "签到码")
    @NotBlank(message = "签到码不能为空")
    private String checkCode;
    @ApiModelProperty(value = "是否签到：0-否/1-是")
    private Integer isChecked;
}
