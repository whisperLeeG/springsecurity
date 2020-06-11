package com.whisper.springsecurity.dao;

import com.whisper.springsecurity.entity.RoleAndPermissionKey;

public interface RoleAndPermissionMapper {
    int deleteByPrimaryKey(RoleAndPermissionKey key);

    int insert(RoleAndPermissionKey record);

    int insertSelective(RoleAndPermissionKey record);
}