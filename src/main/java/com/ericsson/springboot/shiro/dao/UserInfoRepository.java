package com.ericsson.springboot.shiro.dao;

import org.springframework.data.repository.CrudRepository;

import com.ericsson.springboot.shiro.model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long>{  
    
    /**通过username查找用户信息;*/  
    public UserInfo findByUsername(String username);  
     
}  