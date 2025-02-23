package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.Request.LoginUserVo;
import me.caryan.volunteerregistersys.entity.Request.RegisterUserVo;
import me.caryan.volunteerregistersys.entity.po.User;
import me.caryan.volunteerregistersys.entity.response.ResultVo;
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
    public ResultVo<String> registerUser(@RequestBody RegisterUserVo registerUserVo) {
        String tel = registerUserVo.getTel();
        ResultVo response = new ResultVo();
        if (tel.length() == 11 && tel.matches("^1[3-9]\\d{9}$")) {
            if (service.countByTel(tel) == 0) {
                response.setCode(200);
                response.setMessage("注册成功");
                response.setData(tel);
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
    public ResultVo<User> loginUser(@RequestBody LoginUserVo loginUserVo) {
        ResultVo<User> response = new ResultVo<User>();
        String tel = loginUserVo.getTel();
        String password = loginUserVo.getPassword();
        User user = service.selectUserByTel(tel);
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
