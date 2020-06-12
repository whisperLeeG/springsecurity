package com.whisper.springsecurity.dao;

import com.whisper.springsecurity.entity.Role;
import com.whisper.springsecurity.entity.UserAndRoleKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserAndRoleMapper {
    int deleteByPrimaryKey(UserAndRoleKey key);

    int insert(UserAndRoleKey record);

    int insertSelective(UserAndRoleKey record);

    @Select("select role.* from sec_role role,sec_user_role userrole where role.id = userrole.roleid and userrole.userid=#{id}")
    List<Role> getUserRoleByUserId(Long id);
}