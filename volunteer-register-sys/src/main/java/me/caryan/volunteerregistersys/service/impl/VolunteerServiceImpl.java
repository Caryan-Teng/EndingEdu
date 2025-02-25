package me.caryan.volunteerregistersys.service.impl;

import me.caryan.volunteerregistersys.dao.VolunteerMapper;
import me.caryan.volunteerregistersys.entity.po.Volunteer;
import me.caryan.volunteerregistersys.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {
    @Autowired
    private VolunteerMapper mapper;

    @Override
    public Integer insertVolunteer(Volunteer volunteer) {
        if (mapper.selectVolunteerByName(volunteer.getVolunteerName()) == null) {
            return mapper.insertVolunteer(volunteer);
        } else {
            System.out.println("该活动已存在");
            return 0;
        }
    }

    @Override
    public Integer deleteVolunteerByName(String volunteerName) {
        if (mapper.selectVolunteerByName(volunteerName) != null) {
            return mapper.deleteVolunteerByName(volunteerName);
        } else {
            System.out.println("该活动不存在");
            return 0;
        }
    }

    @Override
    public Integer updateVolunteerByName(Volunteer volunteer) {
        if (mapper.selectVolunteerByName(volunteer.getVolunteerName()) != null) {
            return mapper.updateVolunteerByName(volunteer);
        } else {
            System.out.println("该活动不存在");
            return 0;
        }
    }

    @Override
    public Long count() {
        if (mapper.count() != 0) {
            return mapper.count();
        }
        return 0L;
    }

    @Override
    public Volunteer selectVolunteerByName(String volunteerName) {
        if(mapper.selectVolunteerByName(volunteerName)!=null){
            return mapper.selectVolunteerByName(volunteerName);
        }else{
            return null;
        }
    }

    @Override
    public List<Volunteer> selectVolunteerByNameLike(String volunteerName) {
        if (mapper.selectVolunteerByNameLike(volunteerName) != null) {
            return mapper.selectVolunteerByNameLike(volunteerName);
        } else {
            System.out.println("该活动不存在");
            return Collections.emptyList();
        }
    }

    @Override
    public List<Volunteer> selectAllVolunteer() {
        if (mapper.selectAllVolunteer() != null) {
            return mapper.selectAllVolunteer();
        } else {
            System.out.println("该活动不存在");
            return Collections.emptyList();
        }
    }

    @Override
    public List<Volunteer> selectVolunteerOrderByCreateDate() {
        if (mapper.selectVolunteerOrderByCreateDate() != null) {
            return mapper.selectVolunteerOrderByCreateDate();
        } else {
            System.out.println("该活动不存在");
            return Collections.emptyList();
        }
    }

    @Override
    public List<Volunteer> selectVolunteerByLeaderName(String leaderName) {
        if (mapper.selectVolunteerByLeaderName(leaderName) != null) {
            return mapper.selectVolunteerByLeaderName(leaderName);
        } else {
            return Collections.emptyList();
        }
    }
}