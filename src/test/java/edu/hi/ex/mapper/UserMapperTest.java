package edu.hi.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.hi.ex.vo.UserVO;

@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	
	@Test
	void testGetUser() {
		UserVO user = userMapper.getUser("user");
		System.out.println(user);
		
		user = userMapper.getUser("admin");
		System.out.println(user);
		
		user = userMapper.getUser("member");
		System.out.println(user);
		
	}
	
	@Test
	void testInsertUser() {
		
		UserVO user = new UserVO();
		user.setUsername("admin2");
		user.setPassword(new BCryptPasswordEncoder().encode("admin2"));
		user.setEnabled(1);
		
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);

		
	}

}
