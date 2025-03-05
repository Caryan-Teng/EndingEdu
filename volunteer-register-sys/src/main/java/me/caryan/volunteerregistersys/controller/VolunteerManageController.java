package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.po.Volunteer;
import me.caryan.volunteerregistersys.entity.po.VolunteerCreateLog;
import me.caryan.volunteerregistersys.entity.request.CreateVolunteerVo;
import me.caryan.volunteerregistersys.entity.response.ResultVo;
import me.caryan.volunteerregistersys.service.UserService;
import me.caryan.volunteerregistersys.service.VolunteerCreateLogService;
import me.caryan.volunteerregistersys.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RestController
@Api(tags = "志愿活动管理")
public class VolunteerManageController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private UserService userService;
    @Autowired
    private VolunteerCreateLogService volunteerCreateLogService;

    /**
     * 负责人创建志愿活动，传入目前登录的用户的isLeader，会验证是否是负责人
     * @param newVolunteer 志愿活动信息
     * @return 创建成功的数据库记录
     */
    @ApiOperation(value = "创建志愿活动")
    @PostMapping("/volunteer/leader/insert")
    public ResultVo<Volunteer> createVolunteer(@RequestBody @Valid CreateVolunteerVo newVolunteer){
        ResultVo<Volunteer> response = new ResultVo<>();
        if(volunteerService.selectVolunteerByName(newVolunteer.getVolunteerName())!=null){
            response.setCode(500);
            response.setMessage("该志愿活动已存在");
            response.setData(null);
        }else if(userService.selectUserByEmail(newVolunteer.getLeaderEmail())==null
                ||userService.selectUserByEmail(newVolunteer.getLeaderEmail()).getIsLeader()==0){
            response.setCode(500);
            response.setMessage("负责人邮箱不存在或该邮箱不是志愿负责人邮箱");
            response.setData(null);
        }else{
            Volunteer volunteer = new Volunteer().builder()
                    .id(null)
                    .isEnd(0)
                    .isBegin(0)
                    .volunteerName(newVolunteer.getVolunteerName())
                    .volunteerInfo(newVolunteer.getVolunteerInfo())
                    .maxParticipants(newVolunteer.getMaxParticipants())
                    .currentParticipants(0)
                    .checkedParticipants(0)
                    .leaderName(userService.selectUserByEmail(newVolunteer.getLeaderEmail()).getName())
                    .createDate(new Date(System.currentTimeMillis()))
                    .build();
            VolunteerCreateLog volunteerCreateLog = new VolunteerCreateLog().builder()
                    .id(null)
                    .volunteerName(newVolunteer.getVolunteerName())
                    .leaderEmail(newVolunteer.getLeaderEmail())
                    .build();
            volunteerCreateLogService.insertVolunteerCreateLog(volunteerCreateLog);
            Integer resultRowCount = volunteerService.insertVolunteer(volunteer);
            Volunteer checkVolunteer = volunteerService.selectVolunteerByName(newVolunteer.getVolunteerName());
            if(resultRowCount==0||volunteer==null){
                response.setCode(500);
                response.setMessage("创建失败");
                response.setData(null);
            }else{
                response.setCode(200);
                response.setMessage("创建成功");
                response.setData(checkVolunteer);
            }
        }
        return response;
    }

    /**
     * 根据负责人邮箱查询该负责人创建的志愿活动（从该用户的token里面获取）
     * @param leaderEmail 负责人邮箱
     * @return 查询到的负责人创建的志愿活动列表
     */
    @ApiOperation(value = "查询志愿活动")
    @GetMapping("/volunteer/leader/select/{leaderEmail}")
    public ResultVo<List<Volunteer>> selectVolunteerByLeader(@PathVariable("leaderEmail") String leaderEmail){
        ResultVo<List<Volunteer>> response = new ResultVo<>();
        List<VolunteerCreateLog> volunteerCreateLogs = volunteerCreateLogService.selectVolunteerCreateLogByLeaderEmail(leaderEmail);
        if(volunteerCreateLogs.isEmpty()){
            response.setCode(500);
            response.setMessage("该负责人没有创建过志愿活动");
            response.setData(null);
        }else{
            List<Volunteer> volunteers = new ArrayList<>();
            for(int i=0;i<volunteerCreateLogs.size();i++){
                volunteers.add(volunteerService.selectVolunteerByName(volunteerCreateLogs.get(i).getVolunteerName()));
            }
            response.setCode(200);
            response.setMessage("查询成功");
            response.setData(volunteers);
        }
        return response;
    }

    /**
     * 删除志愿活动，只能删除负责人创建的志愿活动（前端验证token），这个删除请求在已经查询到的志愿活动详情页面内发送，可以确保传入参数准确
     * @param deletingVolunteer 志愿活动详情页的志愿信息（先select存缓存，再传参删除）
     * @return 返回删除的志愿活动信息（来自数据库）
     */
    @ApiOperation(value = "删除志愿活动")
    @DeleteMapping("/volunteer/leader/delete")
    public ResultVo<Volunteer> deleteAllVolunteer(@RequestBody @Valid Volunteer deletingVolunteer){
        ResultVo<Volunteer> response = new ResultVo<>();
        if(volunteerService.selectVolunteerByName(deletingVolunteer.getVolunteerName())==null){
            response.setCode(500);
            response.setMessage("该志愿活动不存在");
            response.setData(null);
        }else{
            response.setCode(200);
            response.setMessage("删除成功");
            response.setData(volunteerService.selectVolunteerByName(deletingVolunteer.getVolunteerName()));
            volunteerService.deleteVolunteerByName(deletingVolunteer.getVolunteerName());
        }
        return response;
    }

    /**
     * 一个按钮，用于开启活动（将数据库中活动的is——begin调整为开启）
     * @param beginVolunteer 需要开启的活动类
     * @return 开启后的活动类
     */
    @ApiOperation(value = "开启志愿活动")
    @PutMapping("/volunteer/leader/begin")
    public ResultVo<Volunteer> beginVolunteer(@RequestBody @Valid Volunteer beginVolunteer){
        ResultVo<Volunteer> response = new ResultVo<>();
        if(volunteerService.selectVolunteerByName(beginVolunteer.getVolunteerName())==null){
            response.setCode(500);
            response.setMessage("该志愿活动不存在");
            response.setData(null);
        }else{
            try{
                Volunteer updatedVolunteer = volunteerService.selectVolunteerByName(beginVolunteer.getVolunteerName());
                updatedVolunteer.setIsBegin(1);
                Integer result = volunteerService.updateVolunteerByName(updatedVolunteer);
                if(result!=1){
                    throw new Exception();
                }
                response.setCode(200);
                response.setMessage("开启成功");
                response.setData(volunteerService.selectVolunteerByName(updatedVolunteer.getVolunteerName()));
            }catch (Exception e){
                System.out.println("开启失败");
                response.setCode(500);
                response.setMessage("开启失败");
                response.setData(null);
            }
        }
        return response;
    }
}
