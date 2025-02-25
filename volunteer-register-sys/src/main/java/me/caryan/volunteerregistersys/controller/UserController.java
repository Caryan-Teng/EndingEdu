package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.request.LoginUserVo;
import me.caryan.volunteerregistersys.entity.request.RegisterUserVo;
import me.caryan.volunteerregistersys.entity.po.User;
import me.caryan.volunteerregistersys.entity.response.ResultVo;
import me.caryan.volunteerregistersys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResultVo<String> registerUser(@RequestBody @Valid RegisterUserVo registerUserVo) {
        String email = registerUserVo.getEmail();
        ResultVo<String> response = new ResultVo<         >();
        if (email.length() == 11 && email.matches("^1[3-9]\\d{9}$")) {
            if (service.countByEmail(email) == 0) {
                response.setCode(200);
                response.setMessage("注册成功");
                response.setData(email);
                registerUserVo.setJoinDate(new Date(System.currentTimeMillis()));
                service.insertUser(registerUserVo);
                return response;
            } else {
                response.setCode(500);
                response.setMessage("该电话号码已被注册");
                return response;
            }
        } else {
            response.setCode(501);
            response.setMessage("电话号码格式错误");
            return response;
        }
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public ResultVo<User> loginUser(@RequestBody @Valid LoginUserVo loginUserVo) {
        ResultVo<User> response = new ResultVo<>();
        String email = loginUserVo.getEmail();
        String password = loginUserVo.getPassword();
        User user = service.selectUserByEmail(email);
        if(user==null){
            response.setCode(501);
            response.setMessage("该电话号码不存在");
            response.setData(null);
            return response;
        }else if(user.getPassword().equals(password)){
            response.setCode(200);
            response.setMessage("登录成功");
            response.setData(user);
            return response;
        }else{
            response.setCode(500);
            response.setMessage("密码错误");
            response.setData(null);
            return response;
        }
    }

}
