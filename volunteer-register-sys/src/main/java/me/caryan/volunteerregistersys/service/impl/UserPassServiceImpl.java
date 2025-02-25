package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.dao.UserMapper;
import me.caryan.volunteerregistersys.dao.UserPassMapper;
import me.caryan.volunteerregistersys.service.UserPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserPassServiceImpl implements UserPassService {
    @Autowired
    private UserPassMapper userPassMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insertPass(String email) {
        if (userMapper.selectUserByEmail(email) == null) {
            if(userPassMapper.selectPassByEmail(email) == null){
                Random random = new Random();
                Integer pass1 = 100000 + random.nextInt(900000);// 生成验证码
                String pass = pass1.toString();
                return userPassMapper.insertPass(email, pass);
            }else{
                userPassMapper.deletePassByEmail(email);
                Random random = new Random();
                Integer pass1 = 100000 + random.nextInt(900000);// 生成验证码
                String pass = pass1.toString();
                return userPassMapper.insertPass(email, pass);
            }
        } else {
            System.out.println("该用户已存在");
            return 0;
        }
    }

    @Override
    public String selectPassByEmail(String email) {
        return userPassMapper.selectPassByEmail(email);
    }

    @Override
    public Integer deletePassByEmail(String email) {
        if (userMapper.selectUserByEmail(email) != null) {
            return userPassMapper.deletePassByEmail(email);
        } else {
            return 0;
        }
    }
}
