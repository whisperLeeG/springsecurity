package com.whisper.springsecurity.service;

import com.whisper.springsecurity.dao.RoleMapper;
import com.whisper.springsecurity.dao.UserAndRoleMapper;
import com.whisper.springsecurity.dao.UserMapper;
import com.whisper.springsecurity.entity.Role;
import com.whisper.springsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAndRoleMapper userAndRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        User user = userMapper.selectByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<Role> roles = userAndRoleMapper.getUserRoleByUserId(user.getId());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}
