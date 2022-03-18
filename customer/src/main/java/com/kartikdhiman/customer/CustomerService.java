package com.kartikdhiman.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer.builder()
						.firstName(request.firstName())
						.lastName(request.lastName())
						.email(request.email())
						.build();
		// check if valid email
		// check if email not taken
		// store customer in db
	}
}
