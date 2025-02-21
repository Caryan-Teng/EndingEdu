package me.caryan.volunteerregistersys.entity.po;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "用户信息")
public class User {
    /**
     * 用户id主键
     */
    @ApiModelProperty(value = "用户id主键")
    private Long id;
    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @NotBlank(message = "登录电话不能为空")
    private String tel;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotBlank(message = "登录密码不能为空")
    private String password;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    @NotNull(message = "年龄不能为空")
    private Integer age;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @NotBlank(message = "性别不能为空")
    private String gender;
    /**
     * 工作单位/学校
     */
    @ApiModelProperty(value = "工作单位/学校")
    @NotBlank(message = "工作单位/学校不能为空")
    private String unit;
    /**
     * 职业id
     */
    @ApiModelProperty(value = "职业id")
    @NotNull(message = "职业id不能为空")
    private Long jobId;
    /**
     * 家庭住址
     */
    @ApiModelProperty(value = "家庭住址")
    @NotBlank(message = "家庭住址不能为空")
    private String livingAddress;
    /**
     * 户籍地址id
     */
    @ApiModelProperty(value = "户籍地址id")
    @NotNull(message = "户籍地址id不能为空")
    private Integer registeredAddressId;
    /**
     * 是否为支援负责人：0-否/1-是
     */
    @ApiModelProperty(value = "是否为支援负责人：0-否/1-是")
    @NotNull(message = "是否为支援负责人不能为空")
    private Integer isLeader;
    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    @NotNull(message = "注册时间不能为空")
    private Date joinDate;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    @NotNull(message = "姓名不能为空")
    private String name;
}
