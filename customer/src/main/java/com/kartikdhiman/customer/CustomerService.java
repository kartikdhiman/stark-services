package com.kartikdhiman.customer;

import com.kartikdhiman.clients.fraud.FraudCheckResponse;
import com.kartikdhiman.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	private final FraudClient fraudClient;

	public void registerCustomer(CustomerRegistrationRequest request) {
		var customer = Customer.builder()
						.firstName(request.firstName())
						.lastName(request.lastName())
						.email(request.email())
						.build();
		// check if valid email
		// check if email not taken
		customerRepository.saveAndFlush(customer);

		var fraudster = fraudClient.isFraudster(customer.getId());
		if (fraudster.isFraudulent()) {
			throw new IllegalStateException("fraudster");
		}
	}
}
