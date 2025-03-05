package me.caryan.volunteerregistersys.dao;

import me.caryan.volunteerregistersys.entity.po.Job;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Caryan
* @date 2025/3/5 16:07
*/
@Mapper
public interface JobMapper {
    /**
     * 查询所有职业
     * @return 所有职业信息
     */
    List<Job> selectAllJob();

    /**
     * 按照job_id查询职业
     * @param jobId job_id字段
     * @return 查询到的职业
     */
    Job selectJobById(String jobId);
}
