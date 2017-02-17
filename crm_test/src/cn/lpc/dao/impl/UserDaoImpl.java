package cn.lpc.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lpc.dao.UserDao;
import cn.lpc.domain.User;

@SuppressWarnings("unchecked")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public List<User> findOne(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		return list;
	}

	@Override
	public List<User> findAll() {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User", null);
		return list;
	}
	
}
