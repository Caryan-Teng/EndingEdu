package me.caryan.volunteerregistersys.service;

import me.caryan.volunteerregistersys.entity.po.Job;

import java.util.List;

/**
 * @author Caryan
 * @date 2025/3/5 16:14
 */
public interface JobService {
    /**
     * 查询所有岗位
     * @return 职业列表
     */
    List<Job> selectAllJob();

    /**
     * 按照job_id查询职业
     * @param jobId job_id字段
     * @return 查询到的职业
     */
    Job selectJobById(String jobId);
}
