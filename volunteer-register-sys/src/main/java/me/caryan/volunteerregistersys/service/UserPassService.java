package me.caryan.volunteerregistersys.service;

public interface UserPassService {
    /**
     * 插入用户验证码
     * @param email 邮箱
     */
    Integer insertPass(String email);

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
