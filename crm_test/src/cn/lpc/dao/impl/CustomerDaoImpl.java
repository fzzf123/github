package cn.lpc.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.lpc.dao.CustomerDao;
import cn.lpc.domain.Customer;
import cn.lpc.domain.User;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{

	@Override
	public List<Customer> findAll() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer", null);
		return list;
	}

	@Override
	public List<User> finUserData() {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User", null);
		return list;
	}

	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public List<Customer> findList(DetachedCriteria detachedCriteria) {
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public Customer findOne(Customer customer) {
		return this.getHibernateTemplate().get(Customer.class, customer.getCid());
	}

	@Override
	public void update(Customer newCustomer) {
		this.getHibernateTemplate().update(newCustomer);
	}

}
