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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "志愿活动报名")
public class VolunteerRegisterController {
    @Autowired
    private VolunteerService volunteerService;
    @Autowired
    private UserIsCheckedService userIsCheckedService;

    @ApiOperation(value = "志愿者报名志愿活动(未审核）")
    @PostMapping("/volunteer/user/register")
    public ResultVo<UserIsChecked> registerVolunteer(@RequestBody UserIsCheckedVo userIsCheckedVo) {
        ResultVo<UserIsChecked> response = new ResultVo<>();
        Long userId = userIsCheckedVo.getUserId();
        String volunteerName = userIsCheckedVo.getVolunteerName();
        if (volunteerService.selectVolunteerByName(volunteerName) == null) {
            response.setCode(500);
            response.setMessage("该志愿活动不存在");
            {
                response.setData(null);
            }
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
}
