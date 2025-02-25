package me.caryan.volunteerregistersys.entity.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "志愿活动信息")
@Builder
public class Volunteer {
    @ApiModelProperty(value = "志愿活动id主键")
    private Long id;
    @ApiModelProperty(value = "志愿活动名称")
    private String volunteerName;
    @ApiModelProperty(value = "是否开始：0-否/1-是")
    private Integer isBegin;
    @ApiModelProperty(value = "是否结束：0-否/1-是")
    private Integer isEnd;
    @ApiModelProperty(value = "志愿活动简介")
    private String volunteerInfo;
    @ApiModelProperty(value = "志愿活动创建时间")
    private Date createDate;
    @ApiModelProperty(value = "最大参与人数")
    private Integer maxParticipants;
    @ApiModelProperty(value = "当前参与人数")
    private Integer currentParticipants;
    @ApiModelProperty(value = "已签到参与人数")
    private Integer checkedParticipants;
    @ApiModelProperty(value = "负责人姓名")
    private String leaderName;
}
