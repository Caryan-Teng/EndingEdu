package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.po.Volunteer;
import me.caryan.volunteerregistersys.entity.request.CreateVolunteerVo;
import me.caryan.volunteerregistersys.entity.response.ResultVo;
import me.caryan.volunteerregistersys.service.UserService;
import me.caryan.volunteerregistersys.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Date;


@RestController("/volunteer/leader")
@Api(tags = "志愿活动管理")
public class VolunteerManageController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private UserService userService;
    @ApiOperation(value = "创建志愿活动")
    @PostMapping("/insert")
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
}
