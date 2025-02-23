package me.caryan.volunteerregistersys.service;

import me.caryan.volunteerregistersys.entity.request.RegisterUserVo;
import me.caryan.volunteerregistersys.entity.po.User;

public interface UserService {
    /**
     * 插入用户
     * @param newUser 新用户类
     * @return 插入用户id
     */
    Long insertUser(RegisterUserVo newUser);
    /**
     * 删除用户
     * @param id 用户id
     * @return 删除用户是否成功（1-成功，0-失败）
     */
    Integer deleteUserById(Long id);
    /**
     * 根据用户id查询用户
     * @param id 用户id
     * @return 查询到的用户类
     */
    User selectUserById(Long id);
    /**
     * 根据用户电话查询用户
     * @param tel 用户电话
     * @return 查询到的用户类
     */
    User selectUserByTel(String tel);
    /**
     * 根据用户电话查询用户数量，用于验证是否重复注册
     * @param tel 用户电话
     * @return 查询到的用户数量
     */
    Long countByTel(String tel);
    /**
     * 更新用户信息
     * @param updatedUser 用户类
     * @return 更新用户是否成功（1-成功，0-失败）
     */
    Integer updateUserById(User updatedUser);
}
