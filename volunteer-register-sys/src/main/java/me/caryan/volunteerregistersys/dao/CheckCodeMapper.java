package me.caryan.volunteerregistersys.dao;

import me.caryan.volunteerregistersys.entity.po.VolunteerCheckCode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Caryan
 * @date 2025/3/5 16:38
 */
@Mapper
public interface CheckCodeMapper {
    /**
     * 插入签到码信息
     *
     * @param volunteerCheckCode 签到码对象，包含签到码信息
     * @return 影响的行数，通常为1表示成功，0表示失败
     */
    Integer insertCheckCode(VolunteerCheckCode volunteerCheckCode);

    /**
     * 根据用户邮箱删除签到码信息
     *
     * @param userEmail 用户邮箱，用于定位签到码信息
     * @return 影响的行数，通常为1表示成功，0表示失败
     */
    Integer deleteCheckCodeByUserEmail(String userEmail);

    /**
     * 根据志愿者姓名删除签到码信息
     *
     * @param volunteerName 志愿者姓名，用于定位签到码信息
     * @return 影响的行数，通常为1表示成功，0表示失败
     */
    Integer deleteCheckCodeByVolunteerName(String volunteerName);

    /**
     * 根据用户邮箱查询签到码信息
     *
     * @param userEmail 用户邮箱，用于查询签到码信息
     * @return 返回查询到的签到码对象，如果没有找到，返回null
     */
    VolunteerCheckCode selectCheckCodeByUserEmail(String userEmail);

    /**
     * 根据志愿者姓名查询签到码信息
     *
     * @param volunteerName 志愿者姓名，用于查询签到码信息
     * @return 返回查询到的签到码对象，如果没有找到，返回null
     */
    VolunteerCheckCode selectCheckCodeByVolunteerName(String volunteerName);

}
