package org.alexeykozel.dao;

import java.util.List;

import org.alexeykozel.model.Customer;


/**
 * 
 */

/**
 * @author vsesvit
 *
 */
public interface CustomerDao {
	
	void createCustomer(Customer customer);

    void removeCustomer(Customer customer);

    Customer findCustomerById(long id);
    
    List<Customer> findAllCustomers();
    
}
