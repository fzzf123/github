package cn.lpc.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.lpc.dao.CustomerDao;
import cn.lpc.domain.Customer;
import cn.lpc.domain.User;
import cn.lpc.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public List<User> findUserData() {
		return customerDao.finUserData();
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Customer> findList(DetachedCriteria detachedCriteria) {
		return customerDao.findList(detachedCriteria);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public Customer findOne(Customer customer) {
		return customerDao.findOne(customer);
	}

	@Override
	public void update(Customer newCustomer) {
		customerDao.update(newCustomer);
	}

}
