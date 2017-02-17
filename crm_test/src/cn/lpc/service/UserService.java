package cn.lpc.service;

import java.util.List;

import cn.lpc.domain.User;

public interface UserService {

	List<User> findOne(User user);

	List<User> finAll();

}
