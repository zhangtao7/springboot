package com.tommy.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * 加载配置信息，@ConfigurationProperties原来有location属性，制定配置文件路径，1.5版本后取消
 * 和@PropertySource合用
 * @author etaoazh
 *
 */
@Component
@ConfigurationProperties(prefix="user")
@PropertySource("classpath:/user.properties")
public class ConfigTest {

	private String username;
	private String address;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return " [username=" + username + ", address=" + address + "]";
	}
	
	
}
