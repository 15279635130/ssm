package com.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.bean.User;

public interface UserMapper {

	public int insertUser(User user);

	public int updateUser(User user);

	public int deleteUser(int id);

	public User selectUser(int id);

	public User selectUserByName(String name);

	public List<User> selectUserByMap(Map<String, Integer> paramMap);

	public List<User> selectUserByMix(@Param("name")String name, @Param("limitMap")Map<String, Integer> paramMap);

	public void insertBatch(@Param("users")List<User> datas);

	public List<User> selectAll();
}
