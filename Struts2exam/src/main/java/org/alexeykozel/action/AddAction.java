package org.alexeykozel.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.alexeykozel.dao.CustomerDao;
import org.alexeykozel.dao.SpringJdbcCustomerDao;
import org.alexeykozel.model.Customer;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddAction extends ActionSupport {

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

	public String addCustomer() throws Exception {
		customerDao.createCustomer(getCustomer());
		customerList = customerDao.findAllCustomers();
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public void validate() {
		if (isEmptyString(getCustomer().getLastname()))
			addFieldError("customer.lastname", "Lastname required");
		if (isEmptyString(getCustomer().getFirstname()))
			addFieldError("customer.firstname", "Firstname required");
		if (!isValidEmailAddress(getCustomer().getEmail()))
			addFieldError("customer.email", "Email is not valid");

	}

	private boolean isEmptyString(String value) {
		return value == null || "".equals(value.trim());
	}

	private boolean isValidEmailAddress(String email) {
		String EMAIL_REGEX = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)";
		return email.matches(EMAIL_REGEX);
	}

}
