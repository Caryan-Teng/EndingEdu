package me.caryan.volunteerregistersys.entity.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "创建志愿活动Vo")
public class CreateVolunteerVo {
    @ApiModelProperty(value = "志愿活动名称")
    @NotBlank(message = "志愿活动名称不能为空")
    private String volunteerName;

    @ApiModelProperty(value = "志愿活动简介")
    @NotBlank(message = "志愿活动简介不能为空")
    private String volunteerInfo;

    @ApiModelProperty(value = "最大参与人数")
    @NotNull(message = "最大参与人数不能为空")
    @Min(value = 4, message = "最大参与人数不能小于4")
    @Max(value = 100, message = "最大参与人数不能大于100")
    private Integer maxParticipants;

    @ApiModelProperty(value = "负责人邮箱")
    @NotBlank(message = "负责人邮箱不能为空")
    private String leaderEmail;
}
