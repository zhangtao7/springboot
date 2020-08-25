package com.tommy.springboot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

//@EnableWebMvc
@EnableCaching
@SpringBootApplication
public class Application implements WebMvcConfigurer{
	
	
	
	/*
	 * 
	 * 
	 * 
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		WebMvcConfigurer.super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastJsonConverter=new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig=new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		fastJsonConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastJsonConverter);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//关闭启动信息的2种方法
		
//		SpringApplication app=new SpringApplication(SpringbootApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
		
		//http://patorjk.com/software/taag/，网站生成，copy到banner.txt
		//新建src/main/reources/banner.txt，用来更改启动时的信息，默认是springboot
		//new SpringApplicationBuilder(SpringbootApplication.class)
		//.bannerMode(Banner.Mode.OFF)
		//.run(args);
		
	}
}
