package me.caryan.volunteerregistersys.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPassMapper {
    /**
     * 插入用户验证码
     * @param email 邮箱
     */
    Integer insertPass(String email ,String pass);

    /**
     * 查询用户验证码
     * @param email 邮箱
     * @return 验证码
     */
    String selectPassByEmail(String email);
    /**
     * 删除用户验证码
     * @param email 邮箱
     */
    Integer deletePassByEmail(String email);
}
