package me.caryan.volunteerregistersys.entity.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "岗位信息")
public class Job {
    @ApiModelProperty(value = "职业id主键")
    @NotNull
    private Long id;
    @ApiModelProperty(value = "职业名称")
    @NotBlank
    private String jobName;
    @ApiModelProperty(value = "职业id编号")
    @NotBlank
    private String jobId;
}
