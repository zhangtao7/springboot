package com.tommy.springboot.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfiguration {

	/**
	 anon:所有url都都可以匿名访问;
	authc: 需要认证才能进行访问;
	user:配置记住我或认证通过可以访问；
	这几个是我们会用到的，在这里说明下，其它的请自行查询文档进行学习。
	这时候我们运行程序，访问/index页面我们会发现自动跳转到了login页面，当然这个时候输入账号和密码是无法进行访问的。下面这才是重点：任何身份认证，如何权限控制。
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFactoryBean(SecurityManager securityManager) {
		 ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();
		 // 必须设置 SecurityManager   
	       shiroFilterFactoryBean.setSecurityManager(securityManager);  
	       //拦截器.  
	       Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();  
	       //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了  
	       filterChainDefinitionMap.put("/logout", "logout");  
	       //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;  
	        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->  
	       filterChainDefinitionMap.put("/**", "authc");  
	       // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面  
	        shiroFilterFactoryBean.setLoginUrl("/login");  
	        // 登录成功后要跳转的链接  
	        shiroFilterFactoryBean.setSuccessUrl("/index");  
	        //未授权界面;  
	        shiroFilterFactoryBean.setUnauthorizedUrl("/403");  
	        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);  
	       return shiroFilterFactoryBean;  
	}
	
	
	
	@Bean
	public SecurityManager getSecurityManager() {
		 DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();  
	    return securityManager;  
	}
}
