package com.tommy.springboot.shiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShiroTestController {

	 	@RequestMapping({"/","/index"})
	    public String index(){
	       return"/shiro/index";
	    }

	   

	    @RequestMapping(value="/login",method=RequestMethod.GET)
	    public String login(){
	       return"/shiro/login";
	    }
}
