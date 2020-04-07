package mybatis.demo.controller;



import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mybatis.demo.security02.mapper.UserMapper;

import mybatis.demo.security02.model.User;
import mybatis.demo.security02.model.user_role;

@RestController
@RequestMapping("/logon")
public class LongonController {
	@Autowired
	private UserMapper useMapper;
	
	@PostMapping("addStudent")
	public void addStudent(@RequestBody User user) {
		user.setEnabled(true);
		user.setLocked(false);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		this.useMapper.addStudent(user);
		
		user_role user_role=new user_role();
		user_role.setUid(user.getId());
		user_role.setRid(2);
		this.useMapper.adduser_role2(user_role);
	}
	
	@PostMapping("addTeacher")
	public void addTeacher(@RequestBody User user) {
		user.setEnabled(true);
		user.setLocked(false);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		this.useMapper.addTeacher(user);
		
		user_role user_role=new user_role();
		user_role.setUid(user.getId());
		user_role.setRid(1);
		this.useMapper.adduser_role1(user_role);
	}
	
	
}
