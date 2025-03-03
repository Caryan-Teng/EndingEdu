package me.caryan.volunteerregistersys.dao;

import me.caryan.volunteerregistersys.entity.po.VolunteerCreateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Caryan
 * @date 2025/3/3 14:23
 */
@Mapper
public interface VolunteerCreateLogMapper {
    /**
     * 插入志愿活动创建日志
     * @param volunteerCreateLog 志愿服务创建日志实体类
     * @return 插入成功返回1，否则返回0
     */
    Integer insertVolunteerCreateLog(VolunteerCreateLog volunteerCreateLog);

    /**
     * 按照负责人的邮箱查询志愿活动创建日志
     * @param leaderEmail 负责人邮箱
     * @return 查询到的该负责人的志愿活动创建日志
     */
    List<VolunteerCreateLog> selectVolunteerCreateLogByLeaderEmail(String leaderEmail);
}
