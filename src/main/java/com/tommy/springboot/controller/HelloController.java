package com.tommy.springboot.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Controller
public class HelloController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String testLogLevel() {
	    logger.debug("Logger Level ：DEBUG>>>>>1111111111");
	    logger.info("Logger Level ：INFO>>>>>>>>22222222222222");
	    logger.error("Logger Level ：ERROR>>>>>>>>3333333333333");
	    return "";
	}
	
	
	
	@RequestMapping(value = "/getLoglevel")
	@ResponseBody
	public Level getLogeLevel(@RequestParam(value="package") String packageName) throws Exception {
		LoggerContext loggerContext = (LoggerContext)LoggerFactory.getILoggerFactory();
		return loggerContext.getLogger(packageName).getLevel();
	}
	
	
	
	@RequestMapping("/hello")
    public String hello(){
       return  "hello";
    }
	
	@RequestMapping("/web")
    public String index(){
       return  "websocket";
    }
	
	@RequestMapping("/changeSessionLanauage")
	public String changeSessionLanauage(HttpServletRequest request,String lang) {
		System.out.println(lang);
	       if("zh".equals(lang)){
	           //代码中即可通过以下方法进行语言设置
	           request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN")); 
	       }else if("en".equals(lang)){
	           //代码中即可通过以下方法进行语言设置
	           request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US")); 
	       }

	       return "redirect:/hello";
		//return "hello";
	}
	
	
//	@RequestMapping("/changeSessionLanauage")
//    public String changeSessionLanauage(HttpServletRequest request,HttpServletResponse response,String lang){
//       System.out.println(lang);
//       LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//       if("zh".equals(lang)){
//           localeResolver.setLocale(request, response, new Locale("zh", "CN"));
//       }else if("en".equals(lang)){
//           localeResolver.setLocale(request, response, new Locale("en", "US"));
//       }
//       return "redirect:/hello";
//    }
}
