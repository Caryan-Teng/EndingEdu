package me.caryan.volunteerregistersys.entity.response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "状态Vo")
public class ResultVo<T> {
    /**
     * 注册状态：0-失败/1-成功
     */
    @ApiModelProperty(value = "状态：500-失败/200-成功")
    private Integer code;
    @ApiModelProperty(value = "信息")
    private String message;
    @ApiModelProperty(value = "数据")
    private T data;
}