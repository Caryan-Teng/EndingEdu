package me.caryan.volunteerregistersys.dao;

import me.caryan.volunteerregistersys.entity.po.UserIsChecked;
import me.caryan.volunteerregistersys.entity.request.UserIsCheckedVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Caryan
 * @date 2025/2/26 09:13
 */
@Mapper
public interface UserIsCheckedMapper {
    /**
     * 插入用户检查状态记录
     *
     * @param userIsChecked 要插入的用户检查状态对象
     * @return 插入操作影响的行数
     */
    Integer insertUIC(UserIsChecked userIsChecked);

    /**
     * 根据用户ID和志愿者名称删除用户检查状态记录
     *
     * @param userIsCheckedVo 包含用户ID和志愿者名称的查询对象
     * @return 删除操作影响的行数
     */
    Integer deleteUICByUserIdAndVolunteerName(UserIsCheckedVo userIsCheckedVo);

    /**
     * 根据用户ID和志愿者名称更新检查状态
     *
     * @param userIsCheckedVo 包含更新信息的查询对象
     * @return 更新操作影响的行数
     */
    Integer updateIsCheckedByUserIdAndVolunteerName(UserIsCheckedVo userIsCheckedVo);

    /**
     * 根据志愿者名称选择用户检查状态记录
     *
     * @param volunteerName 志愿者名称
     * @return 匹配的用户检查状态记录列表
     */
    List<UserIsChecked> selectUICByVolunteerName(String volunteerName);

    /**
     * 根据用户ID选择用户检查状态记录
     *
     * @param userId 用户ID
     * @return 匹配的用户检查状态记录列表
     */
    List<UserIsChecked> selectUICByUserId(Long userId);

    /**
     * 根据用户ID和志愿者名称选择用户检查状态记录
     *
     * @param userIsCheckedVo 包含用户ID和志愿者名称的查询对象
     * @return 匹配的用户检查状态记录，如果没有找到匹配的记录则返回null
     */
    UserIsChecked selectUICByUserIdAndVolunteerName(UserIsCheckedVo userIsCheckedVo);

}
