package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.po.Job;
import me.caryan.volunteerregistersys.entity.response.ResultVo;
import me.caryan.volunteerregistersys.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Caryan
 * @date 2025/3/5 16:21
 */
@RestController
@Api(tags = "职业查询")
public class SelectJobController {
    @Autowired
    JobService jobService;
    @GetMapping("/job/select")
    @ApiOperation(value = "查询所有职业")
    public ResultVo<Map<String,String>> selectJob(){
        ResultVo<Map<String,String>> response = new ResultVo<>();
        Map<String,String> jobMap = new HashMap<>();
        List<Job> jobList = jobService.selectAllJob();
        for(Job job:jobList){
            jobMap.put(job.getJobId(),job.getJobName());
        }
        if(jobMap.isEmpty()){
            response.setCode(500);
            response.setMessage("没有查询到职业");
            response.setData(null);
        }else{
            response.setCode(200);
            response.setMessage("查询成功");
            response.setData(jobMap);
        }
        return response;
    }
    @GetMapping("/job/select/{jobId}")
    @ApiOperation(value = "按照job_id查询职业")
    public ResultVo<Job> selectJobById(String jobId){
        ResultVo<Job> response = new ResultVo<>();
        Job job = jobService.selectJobById(jobId);
        if(job==null){
            response.setCode(500);
            response.setMessage("没有查询到该职业");
            response.setData(null);
        }else{
            response.setCode(200);
            response.setMessage("查询成功");
            response.setData(job);
        }
        return response;
    }
}
