package org.alexeykozel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.alexeykozel.model.Customer;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class CustomerParameterizedRowMapper implements
		ParameterizedRowMapper<Customer> {


	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getLong("id"));
		customer.setFirstname(rs.getString("firstname"));
		customer.setLastname(rs.getString("lastname"));
		customer.setEmail(rs.getString("email"));
		customer.setSex(rs.getString("sex"));
		customer.setBirthdate(rs.getDate("birthdate"));
		return customer;
	}

}
