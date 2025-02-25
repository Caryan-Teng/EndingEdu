package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.dao.UserMapper;
import me.caryan.volunteerregistersys.entity.request.RegisterUserVo;
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
        if(mapper.countByEmail(newUser.getEmail())>=1){
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
    public User selectUserByEmail(String email) {
        return mapper.selectUserByEmail(email);
    }

    @Override
    public Long countByEmail(String email) {
        return mapper.countByEmail(email);
    }

    @Override
    public Integer updateUserById(User updatedUser) {
        return mapper.updateUserById(updatedUser);
    }

}
