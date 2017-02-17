package cn.lpc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lpc.domain.Customer;
import cn.lpc.domain.User;

public interface CustomerService {

	List<Customer> findAll();

	List<User> findUserData();

	void save(Customer customer);

	List<Customer> findList(DetachedCriteria detachedCriteria);

	void delete(Customer customer);

	Customer findOne(Customer customer);

	void update(Customer newCustomer);

}
