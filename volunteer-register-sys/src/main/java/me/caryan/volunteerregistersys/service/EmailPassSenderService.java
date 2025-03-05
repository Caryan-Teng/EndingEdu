package me.caryan.volunteerregistersys.service;

/**
 * @author Caryan
 * @date 2025/3/5 13:52
 */
public interface EmailPassSenderService {
    /**
     * 自动发送邮件
     * @param email
     * @param pass
     * @return
     */
    public Integer sendEmail(String email,String pass);
}
