package me.caryan.volunteerregistersys.entity.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api(tags = "注册用户Vo")
public class RegisterUserVo {

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    @NotBlank
    private String tel;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @NotBlank
    private String password;
    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄")
    @NotNull
    private Integer age;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @NotBlank
    private String gender;
    /**
     * 工作单位/学校
     */
    @ApiModelProperty(value = "工作单位/学校")
    @NotBlank
    private String unit;
    /**
     * 职业id
     */
    @ApiModelProperty(value = "职业id")
    @NotNull
    private Long jobId;
    /**
     * 家庭住址
     */
    @ApiModelProperty(value = "家庭住址")
    @NotBlank
    private String livingAddress;
    /**
     * 户籍地址id
     */
    @ApiModelProperty(value = "户籍地址id")
    @NotNull
    private Integer registeredAddressId;
    /**
     * 是否为支援负责人：0-否/1-是
     */
    @ApiModelProperty(value = "是否为支援负责人：0-否/1-是")
    @NotNull
    private Integer isLeader;
    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    private Date joinDate;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
}
