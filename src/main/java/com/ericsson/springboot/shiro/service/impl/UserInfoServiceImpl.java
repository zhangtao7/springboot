package com.ericsson.springboot.shiro.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ericsson.springboot.shiro.dao.UserInfoRepository;
import com.ericsson.springboot.shiro.model.UserInfo;
import com.ericsson.springboot.shiro.service.UserInfoService;

@Service  
public class UserInfoServiceImpl implements UserInfoService{  
     
    @Resource  
    private UserInfoRepository userInfoRepository;  
     
    @Override  
    public UserInfo findByUsername(String username) {  
       System.out.println("UserInfoServiceImpl.findByUsername()");  
       return userInfoRepository.findByUsername(username);  
    }  
     
} 
