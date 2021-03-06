package com.tommy.springboot.controller;

import com.tommy.springboot.config.ConfigTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

	@Autowired
	private ConfigTest configTest;
	
	
	@RequestMapping("/conf")
	public String conf() {
		
		return configTest.toString();
	}
	
	
	@RequestMapping("/myindex")
	public String index() {
		return "index";
	}
}
