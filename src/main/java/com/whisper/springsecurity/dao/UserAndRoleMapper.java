package com.whisper.springsecurity.dao;

import com.whisper.springsecurity.entity.UserAndRoleKey;

public interface UserAndRoleMapper {
    int deleteByPrimaryKey(UserAndRoleKey key);

    int insert(UserAndRoleKey record);

    int insertSelective(UserAndRoleKey record);
}