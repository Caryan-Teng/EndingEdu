package me.caryan.volunteerregistersys.dao;

import me.caryan.volunteerregistersys.entity.po.Volunteer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VolunteerMapper {
    /**
     * 插入一个新的志愿活动记录
     *
     * @param volunteer 志愿活动对象，包含志愿活动的详细信息
     * @return 影响的行数，表示插入成功的记录数
     */
    Integer insertVolunteer(Volunteer volunteer);

    /**
     * 根据志愿活动的ID删除志愿活动记录
     *
     * @param volunteerName 志愿活动的唯一标识符
     * @return 影响的行数，表示删除成功的记录数
     */
    Integer deleteVolunteerByName(String volunteerName);

    /**
     * 根据志愿活动的ID更新志愿活动记录
     *
     * @param volunteer 志愿活动对象，包含更新后的志愿活动信息
     * @return 影响的行数，表示更新成功的记录数
     */
    Integer updateVolunteerByName(Volunteer volunteer);

    /**
     * 计算志愿活动记录的总数
     *
     * @return 志愿活动记录的总数
     */
    Long count();

    /**
     * 根据志愿活动名称模糊查询志愿活动记录
     *
     * @param volunteerName 志愿活动的名称，用于模糊匹配
     * @return 匹配到的志愿活动记录列表
     */
    List<Volunteer> selectVolunteerByNameLike(String volunteerName);

    /**
     * 根据志愿名称查询志愿活动记录
     *
     * @param volunteerName 志愿的名称，用于查询志愿信息
     * @return 返回查询到的志愿对象如果未找到对应名称的志愿者，则返回null
     */
    Volunteer selectVolunteerByName(String volunteerName);
    /**
     * 查询所有的志愿活动记录
     *
     * @return 所有的志愿活动记录列表
     */
    List<Volunteer> selectAllVolunteer();

    /**
     * 根据创建日期排序并查询志愿活动记录
     *
     * @return 按创建日期排序后的志愿活动记录列表
     */
    List<Volunteer> selectVolunteerOrderByCreateDate();

    /**
     * 根据领导者名称查询志愿活动记录
     *
     * @param leaderName 领导者的名称
     * @return 匹配到的志愿活动记录列表
     */
    List<Volunteer> selectVolunteerByLeaderName(String leaderName);


}
