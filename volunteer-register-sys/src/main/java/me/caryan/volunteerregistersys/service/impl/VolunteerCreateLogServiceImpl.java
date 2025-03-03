package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.dao.VolunteerCreateLogMapper;
import me.caryan.volunteerregistersys.entity.po.VolunteerCreateLog;
import me.caryan.volunteerregistersys.service.VolunteerCreateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Caryan
 * @date 2025/3/3 14:41
 */
@Service
public class VolunteerCreateLogServiceImpl implements VolunteerCreateLogService {
    @Autowired
    private VolunteerCreateLogMapper mapper;
    /**
     * 插入志愿活动创建日志
     *
     * @param volunteerCreateLog 志愿服务创建日志实体类
     * @return 插入成功返回1，否则返回0
     */
    @Override
    public Integer insertVolunteerCreateLog(VolunteerCreateLog volunteerCreateLog) {
        return mapper.insertVolunteerCreateLog(volunteerCreateLog);
    }

    /**
     * 按照负责人的邮箱查询志愿活动创建日志
     *
     * @param leaderEmail 负责人邮箱
     * @return 查询到的该负责人的志愿活动创建日志
     */
    @Override
    public List<VolunteerCreateLog> selectVolunteerCreateLogByLeaderEmail(String leaderEmail) {
        if(mapper.selectVolunteerCreateLogByLeaderEmail(leaderEmail) != null){
            return mapper.selectVolunteerCreateLogByLeaderEmail(leaderEmail);
        }else{
            return Collections.emptyList();
        }
    }
}
