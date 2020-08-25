package com.tommy.springboot.shiro.dao;

import org.springframework.data.repository.CrudRepository;

import com.tommy.springboot.shiro.model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long>{  
    
    /**通过username查找用户信息;*/  
    public UserInfo findByUsername(String username);  
     
}  