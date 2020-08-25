package com.tommy.springboot.shiro.service;

import com.tommy.springboot.shiro.model.UserInfo;

public interface UserInfoService {  
    
    /**通过username查找用户信息;*/  
    public UserInfo findByUsername(String username);  
     
}  
