package me.caryan.volunteerregistersys.entity.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "志愿活动参与人员关联信息")
@Builder
public class UserIsChecked {
    @ApiModelProperty(value = "志愿活动参与人员关联信息id主键")
    private Long id;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "志愿活动名称")
    private String volunteerName;
    @ApiModelProperty(value = "是否已签到：-1-未审核/0-否/1-是")
    private Integer isChecked;
}
