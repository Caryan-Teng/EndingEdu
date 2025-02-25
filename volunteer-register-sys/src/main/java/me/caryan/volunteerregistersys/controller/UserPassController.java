package me.caryan.volunteerregistersys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.caryan.volunteerregistersys.entity.po.UserPass;
import me.caryan.volunteerregistersys.entity.request.UserPassVo;
import me.caryan.volunteerregistersys.entity.response.ResultVo;
import me.caryan.volunteerregistersys.service.UserPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController("/register")
@Api(tags = "用户验证码")
public class UserPassController {
    @Autowired
    private UserPassService userPassService;


    @PostMapping("/insertPass")
    @ApiOperation(value = "创建验证码")
    public ResultVo<UserPass> insertPass(@RequestBody String email) {
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            return new ResultVo<>(500,"邮箱格式错误",null);
        }
        Integer result= userPassService.insertPass(email);
        ResultVo<UserPass> resultVo = new ResultVo<>();
        if(result==0){
            resultVo.setCode(500);
            resultVo.setMessage("验证码创建失败");
            resultVo.setData(null);
        }else{
            String pass = userPassService.selectPassByEmail(email);
            UserPass userPass = new UserPass();
            userPass.setEmail(email);
            userPass.setPass(pass);
            resultVo.setCode(200);
            resultVo.setMessage("验证码创建成功");
            resultVo.setData(userPass);
        }
        return resultVo;
    }
    @PostMapping("/checkPass")
    @ApiOperation(value = "验证验证码")
    public ResultVo<String> checkPass(@RequestBody UserPassVo userPassVo){
        ResultVo<String> resultVo = new ResultVo<>();
        if(userPassService.selectPassByEmail(userPassVo.getEmail()).equals(userPassVo.getPass())){
            resultVo.setCode(200);
            resultVo.setMessage("验证码正确");
            resultVo.setData(userPassVo.getEmail());
        }else{
            resultVo.setCode(500);
            resultVo.setMessage("验证码错误");
            resultVo.setData(null);
        }
        return resultVo;
    }
}
