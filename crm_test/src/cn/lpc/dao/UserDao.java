package cn.lpc.dao;

import java.util.List;

import cn.lpc.domain.User;

public interface UserDao {

	List<User> findOne(User user);

	List<User> findAll();

}
