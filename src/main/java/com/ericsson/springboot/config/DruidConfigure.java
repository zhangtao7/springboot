package com.ericsson.springboot.config;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class DruidConfigure<DruidDataSource> {
		
	
	
	/**
	 * 设置国际化，spring默认是AcceptHeaderLocaleContextResolver,从request
	 * 取出 accept-language
	 * 设置成session中取SessionLocaleResolver
	 * @return
	 */
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //设置默认区域,
        slr.setDefaultLocale(Locale.CHINA);
        return slr;

    }
	
	@Bean
	public DataSource getDataSource() {
//		DruidDataSourceBuilder builder=DruidDataSourceBuilder.create();
//		DruidDataSource dataSource=builder.build();
		return DruidDataSourceBuilder.create().build();
	}
	
//	@Bean
//	public ServletRegistrationBean druidStatServlet() {
//		ServletRegistrationBean regist=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//		regist.addInitParameter("allow", "127.0.0.1");
//		regist.addInitParameter("loginUsername", "admin");
//		regist.addInitParameter("loginPassword", "123");
//		regist.addInitParameter("resetEnable", "false");
//		return regist;
//	}
}
