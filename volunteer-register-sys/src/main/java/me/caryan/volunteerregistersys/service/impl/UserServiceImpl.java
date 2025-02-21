package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.dao.UserMapper;
import me.caryan.volunteerregistersys.entity.Request.RegisterUserVo;
import me.caryan.volunteerregistersys.entity.po.User;
import me.caryan.volunteerregistersys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper mapper;

    @Override
    public Long insertUser(RegisterUserVo newUser) {
        if(mapper.countByTel(newUser.getTel())>=1){
            return 0L;
        }else{
            return mapper.insertUser(newUser);
        }
    }

    @Override
    public Integer deleteUserById(Long id) {
        if(mapper.deleteUserById(id)>0){
            return 1;
        }
        return 0;
    }

    @Override
    public User selectUserById(Long id) {
        return mapper.selectUserById(id);
    }

    @Override
    public User selectUserByTel(String tel) {
        return mapper.selectUserByTel(tel);
    }

    @Override
    public Long countByTel(String tel) {
        return mapper.countByTel(tel);
    }

    @Override
    public Integer updateUserById(User updatedUser) {
        return mapper.updateUserById(updatedUser);
    }
}
