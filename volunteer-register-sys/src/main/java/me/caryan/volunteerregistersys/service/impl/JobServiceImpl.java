package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.dao.JobMapper;
import me.caryan.volunteerregistersys.entity.po.Job;
import me.caryan.volunteerregistersys.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author Caryan
 * @date 2025/3/5 16:18
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper mapper;
    /**
     * 查询所有岗位
     *
     * @return 职业列表
     */
    @Override
    public List<Job> selectAllJob() {
        return mapper.selectAllJob();
    }

    /**
     * 按照job_id查询职业
     *
     * @param jobId job_id字段
     * @return 查询到的职业
     */
    @Override
    public Job selectJobById(String jobId) {
        return mapper.selectJobById(jobId);
    }
}
