package org.alexeykozel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.alexeykozel.model.Customer;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SpringJdbcCustomerDao extends JdbcDaoSupport implements
		CustomerDao {

	public void createCustomer(Customer customer) {
		String sql = "INSERT INTO customer "
				+ "(firstname, lastname, birthdate, email, sex) VALUES (?, ?, ?, ? ,?)";

		getJdbcTemplate().update(
				sql,
				new Object[] { customer.getFirstname(), customer.getLastname(),
						customer.getBirthdate(), customer.getEmail(),
						customer.getSex(), });
	}

	public void removeCustomer(Customer customer) {
		getJdbcTemplate().update("DELETE FROM customer WHERE id = ?",
				new Object[] { customer.getId() });

	}

	public Customer findCustomerById(long id) {
		String sql = "SELECT * FROM CUSTOMER WHERE id = ?";
		Customer customer = (Customer) getJdbcTemplate().queryForObject(sql, new Object[] { id }, new CustomerParameterizedRowMapper());
		return customer;
	}

	public List findAllCustomers() {
		String sql = "SELECT * FROM CUSTOMER";
		List customers = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Customer.class));
		return customers;
	}

}