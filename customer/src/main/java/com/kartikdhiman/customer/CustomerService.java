package com.kartikdhiman.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;

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
