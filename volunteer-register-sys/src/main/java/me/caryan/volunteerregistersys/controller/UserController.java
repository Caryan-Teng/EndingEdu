package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.Request.LoginUserVo;
import me.caryan.volunteerregistersys.entity.Request.RegisterUserVo;
import me.caryan.volunteerregistersys.entity.po.User;
import me.caryan.volunteerregistersys.entity.response.state_vo.LoginStateVo;
import me.caryan.volunteerregistersys.entity.response.state_vo.RegisterStateVo;
import me.caryan.volunteerregistersys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@Api(tags = "用户信息")
public class UserController {
    @Autowired
    private UserService service;

    /**
     * 注册用户
     *
     * @param registerUserVo 新用户的请求信息
     * @return 是否注册成功
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册用户")
    public RegisterStateVo registerUser(@RequestBody RegisterUserVo registerUserVo) {
        String tel = registerUserVo.getTel();
        RegisterStateVo response = new RegisterStateVo();
        if (tel.length() == 11 && tel.matches("^1[3-9]\\d{9}$")) {
            if (service.countByTel(tel) == 0) {
                response.setState(1);
                response.setMessage("注册成功");
                response.setTel(tel);
                registerUserVo.setJoinDate(new Date(System.currentTimeMillis()));
                service.insertUser(registerUserVo);
                return response;
            } else {
                response.setState(0);
                response.setMessage("该电话号码已被注册");
                return response;
            }
        } else {
            response.setState(0);
            response.setMessage("电话号码格式错误");
            return response;
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public LoginStateVo loginUser(@RequestBody LoginUserVo loginUserVo) {
        LoginStateVo response = new LoginStateVo();
        String tel = loginUserVo.getTel();
        String password = loginUserVo.getPassword();
        User user = service.selectUserByTel(tel);
        if(user==null){
            response.setState(0);
            response.setMessage("该电话号码不存在");
            response.setIsLeader(null);
            return response;
        }else if(user.getPassword().equals(password)){
            response.setState(1);
            response.setMessage("登录成功");
            response.setIsLeader(user.getIsLeader());
            return response;
        }else{
            response.setState(0);
            response.setMessage("密码错误");
            response.setIsLeader(null);
            return response;
        }
    }

}
