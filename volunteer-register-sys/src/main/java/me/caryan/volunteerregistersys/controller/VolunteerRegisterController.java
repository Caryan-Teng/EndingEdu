package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.po.UserIsChecked;
import me.caryan.volunteerregistersys.entity.po.Volunteer;
import me.caryan.volunteerregistersys.entity.request.UserIsCheckedVo;
import me.caryan.volunteerregistersys.entity.response.ResultVo;
import me.caryan.volunteerregistersys.service.UserIsCheckedService;
import me.caryan.volunteerregistersys.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "志愿活动报名")
public class VolunteerRegisterController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private UserIsCheckedService userIsCheckedService;

    /**
     * 报名志愿活动，默认是-1未审核状态，同时将已报名人数加1
     * @param userIsCheckedVo 用户报名状态（isChecked填-1）
     * @return 添加成功的用户报名状态记录
     */
    @ApiOperation(value = "志愿者报名志愿活动(未审核:-1/已审核:0/已签到:1/）")
    @PostMapping("/volunteer/user/register")
    public ResultVo<UserIsChecked> registerVolunteer(@RequestBody UserIsCheckedVo userIsCheckedVo) {
        ResultVo<UserIsChecked> response = new ResultVo<>();
        String volunteerName = userIsCheckedVo.getVolunteerName();
        if (volunteerService.selectVolunteerByName(volunteerName) == null) {
            response.setCode(500);
            response.setMessage("该志愿活动不存在");
            response.setData(null);

        } else {
            Volunteer volunteer = volunteerService.selectVolunteerByName(volunteerName);
            if (volunteer.getCurrentParticipants().equals(volunteer.getMaxParticipants())) {
                response.setCode(500);
                response.setMessage("该志愿活动已满员");
                response.setData(null);
            } else {
                userIsCheckedService.insertUIC(userIsCheckedVo);
                response.setCode(200);
                response.setMessage("报名成功");
                response.setData(userIsCheckedService.selectUICByUserIdAndVolunteerName(userIsCheckedVo));
            }
        }
        return response;
    }

    /**
     * 用来修改报名状态：-1是未审核，0是已审核，1是已签到，负责人可以访问这个请求来修改志愿者的报名状态
     * @param userIsCheckedVo 用户报名状态
     * @return 修改后的用户报名状态
     */
    @ApiOperation(value = "更新报名状态")
    @PutMapping("/volunteer/user/update")
    public ResultVo<UserIsChecked> updateVolunteer(@RequestBody UserIsCheckedVo userIsCheckedVo) {
        ResultVo<UserIsChecked> response = new ResultVo<>();
        if (volunteerService.selectVolunteerByName(userIsCheckedVo.getVolunteerName()) == null) {
            response.setCode(500);
            response.setMessage("该志愿活动不存在");
            response.setData(null);
        } else if (userIsCheckedService.selectUICByUserId(userIsCheckedVo.getUserId()).isEmpty()) {
            response.setCode(500);
            response.setMessage("该用户未报名该志愿活动");
            response.setData(null);
        } else {
            if (userIsCheckedVo.getIsChecked() == 0) {//已报名人数加1
                Integer currentParticipants = volunteerService.selectVolunteerByName(
                        userIsCheckedVo.getVolunteerName()).getCurrentParticipants();
                currentParticipants++;
                Volunteer volunteer = volunteerService.selectVolunteerByName(userIsCheckedVo.getVolunteerName());
                volunteer.setCurrentParticipants(currentParticipants);
                volunteerService.updateVolunteerByName(volunteer);
            } else if (userIsCheckedVo.getIsChecked() == 1) {// 已签到人数加1
                Integer CheckedPaticipants = volunteerService.selectVolunteerByName(
                        userIsCheckedVo.getVolunteerName()).getCheckedParticipants();
                CheckedPaticipants++;
                Volunteer volunteer = volunteerService.selectVolunteerByName(userIsCheckedVo.getVolunteerName());
                volunteer.setCheckedParticipants(CheckedPaticipants);
                volunteerService.updateVolunteerByName(volunteer);
            }
            userIsCheckedService.updateIsCheckedByUserIdAndVolunteerName(userIsCheckedVo);
            response.setCode(200);
            response.setMessage("更新成功");
            response.setData(userIsCheckedService.selectUICByUserIdAndVolunteerName(userIsCheckedVo));
        }
        return response;
    }

    /**
     * 取消报名，其实就是删除报名状态表的记录，还有将已报名人数或者已签到人数减1
     * @param userIsCheckedVo 要删除的用户报名状态
     * @return 删除是否成功和message一样
     */
    @ApiOperation(value = "取消报名")
    @DeleteMapping("/volunteer/user/delete")
    public ResultVo<String> deleteVolunteer(@RequestBody UserIsCheckedVo userIsCheckedVo) {
        ResultVo<String> response = new ResultVo<>();
        if (userIsCheckedService.selectUICByUserIdAndVolunteerName(userIsCheckedVo) == null) {
            response.setCode(500);
            response.setMessage("该志愿活动不存在");
            response.setData(null);
        } else {
            if (userIsCheckedVo.getIsChecked() == 0||userIsCheckedVo.getIsChecked() == 1) {//已报名人数-1
                Integer currentParticipants = volunteerService.selectVolunteerByName(
                        userIsCheckedVo.getVolunteerName()).getCurrentParticipants();
                currentParticipants--;
                Volunteer volunteer = volunteerService.selectVolunteerByName(userIsCheckedVo.getVolunteerName());
                volunteer.setCurrentParticipants(currentParticipants);
                volunteerService.updateVolunteerByName(volunteer);
            }
            if (userIsCheckedVo.getIsChecked() == 1) {// 已签到人数-1
                Integer CheckedPaticipants = volunteerService.selectVolunteerByName(
                        userIsCheckedVo.getVolunteerName()).getCheckedParticipants();
                CheckedPaticipants--;
                Volunteer volunteer = volunteerService.selectVolunteerByName(userIsCheckedVo.getVolunteerName());
                volunteer.setCheckedParticipants(CheckedPaticipants);
                volunteerService.updateVolunteerByName(volunteer);
            }
            System.out.println(userIsCheckedService.selectUICByUserIdAndVolunteerName(userIsCheckedVo));
            userIsCheckedService.deleteUICByUserIdAndVolunteerName(userIsCheckedVo);
            response.setCode(200);
            response.setMessage("删除成功");
            response.setData("删除成功");
        }
        return response;
    }
}
