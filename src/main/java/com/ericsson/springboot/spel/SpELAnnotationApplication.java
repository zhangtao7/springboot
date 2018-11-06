package com.ericsson.springboot.spel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages={"com.ericsson.springboot.spel"})
public class SpelMain {

	 public static void main(String[] args) {
		 SpringApplication.run(SpelMain.class, args);
	 }
}
