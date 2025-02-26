package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.dao.UserIsCheckedMapper;
import me.caryan.volunteerregistersys.entity.po.UserIsChecked;
import me.caryan.volunteerregistersys.entity.request.UserIsCheckedVo;
import me.caryan.volunteerregistersys.service.UserIsCheckedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
/**
 * @author Caryan
 * @date 2025/2/26 10:09
 */ public class UserIsCheckedServiceImpl implements UserIsCheckedService {
    @Autowired
    private UserIsCheckedMapper mapper;

    /**
     * 根据用户ID和志愿者名称删除用户检查状态记录
     *
     * @param userIsCheckedVo 包含用户ID和志愿者名称的查询对象
     * @return 删除操作影响的行数
     */
    @Override
    public Integer deleteUICByUserIdAndVolunteerName(UserIsCheckedVo userIsCheckedVo) {
        if(mapper.selectUICByUserIdAndVolunteerName(userIsCheckedVo)==null){
            return 0;
        }else{
            return mapper.deleteUICByUserIdAndVolunteerName(userIsCheckedVo);
        }
    }

    /**
     * 插入用户检查状态记录
     *
     * @param userIsCheckedVo 要插入的用户检查状态对象
     * @return 插入操作影响的行数
     */
    @Override
    public Integer insertUIC(UserIsCheckedVo userIsCheckedVo) {
        if(mapper.selectUICByUserIdAndVolunteerName(userIsCheckedVo)==null){
            UserIsChecked userIsChecked=new UserIsChecked().builder()
                    .userId(userIsCheckedVo.getUserId())
                    .volunteerName(userIsCheckedVo.getVolunteerName())
                    .id(null)
                    .isChecked(-1)
                    .build();
            return mapper.insertUIC(userIsChecked);
        }else{
            return 0;
        }
    }

    /**
     * 根据用户ID选择用户检查状态记录
     *
     * @param userId 用户ID
     * @return 匹配的用户检查状态记录列表
     */
    @Override
    public List<UserIsChecked> selectUICByUserId(Long userId) {
        if(mapper.selectUICByUserId(userId)!=null){
            return mapper.selectUICByUserId(userId);
        }else{
            return Collections.emptyList();
        }
    }

    /**
     * 根据用户ID和志愿者名称选择用户检查状态记录
     *
     * @param userIsCheckedVo 包含用户ID和志愿者名称的查询对象
     * @return 匹配的用户检查状态记录，如果没有找到匹配的记录则返回null
     */
    @Override
    public UserIsChecked selectUICByUserIdAndVolunteerName(UserIsCheckedVo userIsCheckedVo) {
        return mapper.selectUICByUserIdAndVolunteerName(userIsCheckedVo);
    }

    /**
     * 根据志愿者名称选择用户检查状态记录
     *
     * @param volunteerName 志愿者名称
     * @return 匹配的用户检查状态记录列表
     */
    @Override
    public List<UserIsChecked> selectUICByVolunteerName(String volunteerName) {
        return mapper.selectUICByVolunteerName(volunteerName);
    }

    /**
     * 根据用户ID和志愿者名称更新检查状态
     *
     * @param userIsCheckedVo 包含更新信息的查询对象
     * @return 更新操作影响的行数
     */
    @Override
    public Integer updateIsCheckedByUserIdAndVolunteerName(UserIsCheckedVo userIsCheckedVo) {
        if(mapper.selectUICByUserIdAndVolunteerName(userIsCheckedVo)!=null){
            return mapper.updateIsCheckedByUserIdAndVolunteerName(userIsCheckedVo);
        }else{
            return 0;
        }
    }
}
