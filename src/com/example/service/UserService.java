package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.User;
import com.example.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(Integer id) {
		User user = userMapper.selectUser(id);
		return user;
	}

	public void insertBatch(List<User> datas) {
		userMapper.insertBatch(datas);
	}

	public List<User> getUserList() {
		return userMapper.selectAll();
	}
}
