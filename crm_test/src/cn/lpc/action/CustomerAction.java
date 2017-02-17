package cn.lpc.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.lpc.domain.Customer;
import cn.lpc.domain.User;
import cn.lpc.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	public String list() throws Exception {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCustName())){
			detachedCriteria.add(Restrictions.like("custName", customer.getCustName(),MatchMode.ANYWHERE));;
			if(StringUtils.isNotBlank(customer.getCustType())){
				detachedCriteria.add(Restrictions.like("custType", customer.getCustType(),MatchMode.ANYWHERE));;
			}
		}
		List<Customer> list=customerService.findList(detachedCriteria);
		if(list!=null&&list.size()>0){
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		ServletActionContext.getRequest().setAttribute("customer", customer);
		return "list";
	}
	
	public String toAdd() throws Exception {
		List<User> list = customerService.findUserData();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toAdd";
	}
	
	public String add() throws Exception {
		customerService.save(customer);
		return "success";
	}
	
	public String delete() throws Exception {
		customer = customerService.findOne(customer);
		customerService.delete(customer);
		return "success";
	}
	
	public String toEdit() throws Exception {
		customer = customerService.findOne(customer);
		List<User> list = customerService.findUserData();
		ServletActionContext.getRequest().setAttribute("customer", customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toEdit";
	}
	
	public String update() throws Exception {
		Customer newCustomer = customerService.findOne(customer);
		newCustomer.setCustAddress(customer.getCustAddress());
		newCustomer.setCustLinkUser(customer.getCustLinkUser());
		newCustomer.setCustName(customer.getCustName());
		newCustomer.setCustPhone(customer.getCustPhone());
		newCustomer.setCustType(customer.getCustType());
		customerService.update(newCustomer);
		return "success";
	}
}
