package com.ericsson.springboot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ericsson.springboot.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@EnableAutoConfiguration
//@DataJpaTest
public class UserReposityTest {

	
	@Test
	public void testAdd() {
		//userRepository.save(new User("sssssss","fffff"));
	}
	
	@Test
	public void testPlayerRepository() {
	}
}
