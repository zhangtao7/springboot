package com.ericsson.springboot.shiro.service;

import com.ericsson.springboot.shiro.model.UserInfo;

public interface UserInfoService {  
    
    /**通过username查找用户信息;*/  
    public UserInfo findByUsername(String username);  
     
}  
