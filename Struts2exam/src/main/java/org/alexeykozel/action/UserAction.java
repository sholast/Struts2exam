package org.alexeykozel.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.alexeykozel.dao.CustomerDao;
import org.alexeykozel.model.Customer;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	private Customer customer;
	private List<Customer> customerList;
	private CustomerDao customerDao;

	public String execute() throws Exception {
		return SUCCESS;
	}

	public String toAddForm() {
		return SUCCESS;

	}

	public String addCustomer() throws Exception {
		customerDao.createCustomer(getCustomer());
		customerList = customerDao.findAllCustomers();
		return SUCCESS;

	}

	public String listUser() throws Exception {
		customerList = customerDao.findAllCustomers();
		return SUCCESS;

	}

	public String removeCustomer() throws Exception {
		long id = Long.parseLong(getServletRequest().getParameter("id"));
		customer = customerDao.findCustomerById(id);
		customerDao.removeCustomer(customer);
		customerList = customerDao.findAllCustomers();
		customer = new Customer();
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
