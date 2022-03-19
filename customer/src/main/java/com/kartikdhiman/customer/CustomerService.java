package com.kartikdhiman.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
						.firstName(request.firstName())
						.lastName(request.lastName())
						.email(request.email())
						.build();
		// check if valid email
		// check if email not taken
		customerRepository.save(customer);
	}
}