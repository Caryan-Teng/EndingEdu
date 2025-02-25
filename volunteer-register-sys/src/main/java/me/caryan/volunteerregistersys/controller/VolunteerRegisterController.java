//package me.caryan.volunteerregistersys.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import me.caryan.volunteerregistersys.entity.po.Volunteer;
//import me.caryan.volunteerregistersys.entity.po.VolunteerUserIsChecked;
//import me.caryan.volunteerregistersys.entity.request.RegisterVolunteerVo;
//import me.caryan.volunteerregistersys.entity.response.ResultVo;
//import me.caryan.volunteerregistersys.service.VolunteerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController("/volunteer/user")
//@Api(tags = "志愿活动报名")
//public class VolunteerRegisterController {
//    @Autowired
//    private VolunteerService volunteerService;
//    @ApiOperation(value = "志愿者报名志愿活动")
//    @PostMapping("/register")
//    public ResultVo<VolunteerUserIsChecked> registerVolunteer(@RequestBody RegisterVolunteerVo registerVolunteerVo) {
//        ResultVo<VolunteerUserIsChecked> response = new ResultVo<>();
//        Long userId = registerVolunteerVo.getUserId();
//        String volunteerName = registerVolunteerVo.getVolunteerName();
//        if(volunteerService.selectVolunteerByName(volunteerName)==null){
//            response.setCode(500);
//            response.setMessage("该志愿活动不存在");{
//                response.setData(null);
//            }
//        }else{
//            Volunteer volunteer = volunteerService.selectVolunteerByName(volunteerName);
//            if(volunteer.getCurrentParticipants().equals(volunteer.getMaxParticipants())){
//                response.setCode(500);
//                response.setMessage("该志愿活动已满员");
//                response.setData(null);
//            }
//        }
//    }
//}
